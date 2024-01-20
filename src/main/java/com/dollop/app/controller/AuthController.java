
package com.dollop.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.AuthRequest;
import com.dollop.app.entity.payload.AuthResponse;
import com.dollop.app.entity.payload.PermissionsAccess;
import com.dollop.app.entity.payload.UserRegistrationRequest;
import com.dollop.app.entity.payload.UserRegistrationResponse;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.fileUtils.FileService;
import com.dollop.app.service.IAuthenticationService;
import com.dollop.app.service.admin.IUsersService;

import com.dollop.app.utils.ChangePasswordUtils;

import com.dollop.app.utils.EmailUtils;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/rise/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private FileService fileService;
	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private IUsersService service;

	@Autowired
	private EmailUtils emailUtils;

	@PostMapping("/signup")
	public ResponseEntity<UserRegistrationResponse> registration(
			@RequestBody UserRegistrationRequest registrationRequest) throws MessagingException, IOException {

		return new ResponseEntity<UserRegistrationResponse>(
				this.authenticationService.registration(registrationRequest), HttpStatus.CREATED);
	}

	@GetMapping("/resend")
	public ResponseEntity<Boolean> resendOptForVerification(@RequestParam("email") String regirterEmail,
			@RequestParam("forType") String forType) throws MessagingException, IOException {

		return new ResponseEntity<Boolean>(this.authenticationService.resendOptForVerification(regirterEmail, forType),
				HttpStatus.ACCEPTED);

	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		return new ResponseEntity<AuthResponse>(this.authenticationService.login(authRequest), HttpStatus.ACCEPTED);
	}

	@GetMapping("/verifies")
	public ResponseEntity<UserRegistrationResponse> verify(@RequestParam("email") String email,
			@RequestParam("value") String otp) {
		return new ResponseEntity<UserRegistrationResponse>(this.authenticationService.verifyUser(email, otp),
				HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/basicDetails", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<UsersResponse> adUserBasicDetails(
			@RequestPart(value = "files[]", required = false) MultipartFile file,
			@RequestPart("data") UsersRequest usersRequest) {

		return new ResponseEntity<UsersResponse>(this.service.addUserBasicDetails(usersRequest, file),
				HttpStatus.CREATED);
	}

	@GetMapping("/current-user")
	public ResponseEntity<UsersResponse> getCurrentUser(Principal p) {
		return new ResponseEntity<UsersResponse>(this.authenticationService.getCurrentUser(p.getName()), HttpStatus.OK);
	}

	@GetMapping("/access")
	public ResponseEntity<List<Roles>> getPermissionAccess(Principal p) {
		return new ResponseEntity<List<Roles>>(this.authenticationService.getPermissionAccess(p.getName()),
				HttpStatus.OK);
	}

	@GetMapping("/isPermitted")
	public ResponseEntity<Boolean> isUserPermitted(Principal p, @RequestParam("url") String url) {
		return new ResponseEntity<>(this.authenticationService.isPermitted(p.getName(), url), HttpStatus.OK);
	}

	@GetMapping("/isPermitted/{isGuard}")
	public ResponseEntity<?> isUserPermitted(Principal p, @RequestParam("url") String url,
			@PathVariable("isGuard") Boolean isGuard) {
		return this.authenticationService.isPermitted(p.getName(), url, isGuard);
	}

	@GetMapping("/sidenav")
	public ResponseEntity<PermissionsAccess> getSidenavPermissionAccess(Principal p) {
		return new ResponseEntity<PermissionsAccess>(this.authenticationService.getSidenavPermissionAccess(p.getName()),
				HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/file/getImageApi/{destination}/{fileName}", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public void getImage(@PathVariable("fileName") String fileName, @PathVariable("destination") String destination,
			HttpServletResponse response) throws IOException {
		InputStream data = fileService.getImages(fileName, destination);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		try {
			StreamUtils.copy(data, response.getOutputStream());
		} catch (IllegalArgumentException e) {

		}

	}

	@PutMapping("/forget")
	public ResponseEntity<Boolean> changeForgetPassword(@RequestBody AuthRequest authRequest,
			@PathParam("otp") String otp) {
		return new ResponseEntity<Boolean>(this.authenticationService.changeForgetPassword(authRequest, otp),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/changePassword/{oldPassword}/{newPassword}")
	public ResponseEntity<Boolean> changePassword(@PathVariable String oldPassword, @PathVariable String newPassword,
			Principal principal) {

		return new ResponseEntity<Boolean>(this.authenticationService.channgePassword(
				new ChangePasswordUtils(oldPassword, newPassword), principal.getName()), HttpStatus.ACCEPTED);
	}

}
