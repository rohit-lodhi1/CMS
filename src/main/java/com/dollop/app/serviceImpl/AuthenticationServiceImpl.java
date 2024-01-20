package com.dollop.app.serviceImpl;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.UserRegistration;
import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.AuthRequest;
import com.dollop.app.entity.payload.AuthResponse;
import com.dollop.app.entity.payload.PermissionsAccess;
import com.dollop.app.entity.payload.UserRegistrationRequest;
import com.dollop.app.entity.payload.UserRegistrationResponse;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.exception.AuthenticationFailedException;
import com.dollop.app.exception.PasswordNotMatchException;
import com.dollop.app.exception.UserAlreadyPresentException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ModulePermissionsRepository;
import com.dollop.app.repository.PermissionRepository;
import com.dollop.app.repository.UserRegistrationRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IAuthenticationService;
import com.dollop.app.service.admin.IUsersService;
import com.dollop.app.utils.ChangePasswordUtils;
import com.dollop.app.utils.EmailUtils;
import com.dollop.app.utils.JWTUtils;

import jakarta.mail.MessagingException;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private UserRegistrationRepository registrationRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private ModulePermissionsRepository modulePermissionsRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTUtils jwtUtils;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private IUsersService usersService;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	public UserRegistration userRegistrationRequestToUserRegistration(UserRegistrationRequest registrationRequest) {
		return this.modelMapper.map(registrationRequest, UserRegistration.class);
	}

	public UserRegistrationResponse userRegistrationToUserRegistrationResponse(UserRegistration registration) {
		return this.modelMapper.map(registration, UserRegistrationResponse.class);
	}

	// user registration
	@Override
	public UserRegistrationResponse registration(UserRegistrationRequest registrationRequest) {
		// checking email already exists or not
		boolean isPresent = this.registrationRepository.existsByEmailAndActive(registrationRequest.getEmail(), true);
		if (isPresent)
			throw new UserAlreadyPresentException(AppConstants.USER_ALREADY_PRESENT + registrationRequest.getEmail());

		Optional<UserRegistration> already = this.registrationRepository
				.findByEmailAndActive(registrationRequest.getEmail(), false);
		UserRegistration registration;
		if (already.isPresent()) {
			registration = already.get();
			registration.setEmail(registrationRequest.getEmail());
			registration.setUserName(registrationRequest.getUserName());

		} else
			registration = this.userRegistrationRequestToUserRegistration(registrationRequest);

		// otp generating
		registration.setOtp(this.generateOtp());

		// password encoding
		registration.setPassword(passwordEncoder.encode(registration.getPassword()));

		registration.setGeneratedTime(LocalDateTime.now());

		registration = this.registrationRepository.save(registration);

		try {
			emailUtils.sendEmail(registration.getEmail(), registration.getUserName(), registration.getOtp());
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return this.userRegistrationToUserRegistrationResponse(registration);
	}

	private String generateOtp() {
		// Generate a random 4-digit OTP
		SecureRandom secureRandom = new SecureRandom();
		int otp = secureRandom.nextInt(9000) + 1000;

		return String.valueOf(otp);
	}

	@Override
	public AuthResponse login(AuthRequest authRequest) {
		this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		String token = jwtUtils.generateToken(authRequest.getEmail());
		AuthResponse response = new AuthResponse();
		response.setToken(token);
		response.setDescription("Welcome!!!!!");
		return response;
		
	}

	@Override
	public UserRegistrationResponse verifyUser(String email, String otp) {

		UserRegistration userRegistration = this.registrationRepository.findByEmailAndActive(email, false)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));

		if (!userRegistration.getOtp().equals(otp)
				&& Duration.between(userRegistration.getGeneratedTime(), LocalDateTime.now()).getSeconds() > (5 * 60)) {
			if (Duration.between(userRegistration.getGeneratedTime(), LocalDateTime.now()).getSeconds() > (5 * 60))
				throw new AuthenticationFailedException(AppConstants.OTP_VERIFICATION_TIMEOUT);
			else
				throw new AuthenticationFailedException(AppConstants.OTP_VERIFICATION_INVALID);
		}

		userRegistration.setActive(true);
		Optional<Users> isAvailable = this.usersRepository.findByEmail(userRegistration.getEmail());
		if (isAvailable.isPresent()) {
			throw new UserAlreadyPresentException(AppConstants.USER_ALREADY_PRESENT + " " + email);
		}
		Users user = new Users();
		user.setEmail(userRegistration.getEmail());

		user.setPassword(userRegistration.getPassword());

		Set<UserRoles> userRoles = new HashSet<>();
		UserRoles userRole = new UserRoles();
		Roles roles = new Roles();
		roles.setId(AppConstants.EMPLOYEE_ROLE_ID);
		userRole.setRoles(roles);
		userRoles.add(userRole);

		user.setUserRoles(userRoles);
		this.usersRepository.save(user);
		this.registrationRepository.save(userRegistration);
		return this.userRegistrationToUserRegistrationResponse(userRegistration);
	}

	@Override
	public UsersResponse getCurrentUser(String email) {
		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));

		return this.usersService.userToUserResponse(user);
	}

	@Override
	public List<Roles> getPermissionAccess(String email) {
		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		Set<UserRoles> userRoles = user.getUserRoles();
		List<Roles> roles = new ArrayList<>();
		userRoles.stream().forEach(u -> {
			Roles role = u.getRoles();

			List<Permissions> permissions = this.permissionRepository.findByRole(role);

			role.setPermissions(permissions);
			roles.add(role);
		});
		return roles;
	}

	public Boolean isPermitted(String email, String url) {
//		System.out.println(url);

		if (url.equals("/dollop"))
			return true;

		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		Set<UserRoles> userRoles = user.getUserRoles();

		for (UserRoles u : userRoles) {

			Roles role = u.getRoles();
			List<Permissions> permissions = this.permissionRepository.findByRole(role);
			for (Permissions p : permissions) {

				if (url.toLowerCase().contains(p.getTitle().toLowerCase()) && p.getIsReadable())
					return true;

			}

		}

		return false;
	}

	public ResponseEntity<?> isPermitted(String email, String url, Boolean isGuard) {
	
		if (url.equals("/dollop") || url.equals("/employee-dash"))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);

		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		Set<UserRoles> userRoles = user.getUserRoles();

		for (UserRoles u : userRoles) {

			Roles role = u.getRoles();
			List<Permissions> permissions = this.permissionRepository.findByRole(role);
			for (Permissions p : permissions) {

				if (url.toLowerCase().contains(p.getTitle().toLowerCase()) && p.getIsReadable()) {
					if (isGuard)
						return new ResponseEntity<Boolean>(true, HttpStatus.OK);
					return new ResponseEntity<Permissions>(p, HttpStatus.OK);
				}

			}

		}
		if (isGuard)
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
		return null;
	}

	public PermissionsAccess getSidenavPermissionAccess(String email) {
		PermissionsAccess access = new PermissionsAccess();

		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		Set<UserRoles> userRoles = user.getUserRoles();
		Map<String, Boolean> permission = new HashMap<>();
		for (UserRoles u : userRoles) {

			Roles role = u.getRoles();

			List<Permissions> permissions = this.permissionRepository.findByRole(role);
			permissions.stream().forEach(p -> {

				if (permission.containsKey(p.getTitle())) {
					if (Objects.nonNull(permission.get(p.getTitle())) && permission.get(p.getTitle()) == false)
						permission.put(p.getTitle(), p.getIsReadable());
				} else
					permission.put(p.getTitle(), p.getIsReadable());
			});

		}

		access.setPermission(permission);

		return access;
	}

	@Override
	public Boolean resendOptForVerification(String regirterEmail,String forType) {
		Boolean isActive=true;
		if(forType.equals("resend")) {
			isActive=false;
		}
		UserRegistration user = this.registrationRepository.findByEmailAndActive(regirterEmail, isActive).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + regirterEmail));
		// otp generating
		user.setOtp(this.generateOtp());

		user.setGeneratedTime(LocalDateTime.now());

		user = this.registrationRepository.save(user);

		try {
			emailUtils.sendEmail(user.getEmail(), user.getUserName(), user.getOtp());
			return true;
		} catch (MessagingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean changeForgetPassword(AuthRequest authRequest, String otp) {
		UserRegistration userRegistration = this.registrationRepository.findByEmailAndActive(authRequest.getEmail(), true)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + authRequest.getEmail()));

		if (!userRegistration.getOtp().equals(otp)
				&& Duration.between(userRegistration.getGeneratedTime(), LocalDateTime.now()).getSeconds() > (5 * 60)) {
			if (Duration.between(userRegistration.getGeneratedTime(), LocalDateTime.now()).getSeconds() > (5 * 60))
				throw new AuthenticationFailedException(AppConstants.OTP_VERIFICATION_TIMEOUT);
			else
				throw new AuthenticationFailedException(AppConstants.OTP_VERIFICATION_INVALID);
		}

		 Users user = this.usersRepository.findByEmail(authRequest.getEmail()).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + authRequest.getEmail()));
           user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
           if (usersRepository.save(user)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean channgePassword(ChangePasswordUtils changePasswordUtils, String email) {
	       Users user = this.usersRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		if(user!=null) {
			if(passwordEncoder.matches(changePasswordUtils.getOldPassword(), user.getPassword())) {
				user.setPassword(passwordEncoder.encode(changePasswordUtils.getNewPassword()));
				this.usersRepository.save(user);
			}
			else {
		       throw new PasswordNotMatchException(AppConstants.PASSWORD_NOT_MATCH);
			}
		}
		
		return false;

}
}
