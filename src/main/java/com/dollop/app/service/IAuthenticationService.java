package com.dollop.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.AuthRequest;
import com.dollop.app.entity.payload.AuthResponse;
import com.dollop.app.entity.payload.PermissionsAccess;
import com.dollop.app.entity.payload.UserRegistrationRequest;
import com.dollop.app.entity.payload.UserRegistrationResponse;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.utils.ChangePasswordUtils;

public interface IAuthenticationService {

	public UserRegistrationResponse registration(UserRegistrationRequest registrationRequest);

	public AuthResponse login(AuthRequest authRequest);
	public Boolean changeForgetPassword(AuthRequest authRequest,String otp);

	public UserRegistrationResponse verifyUser(String time, String otp);

	public UsersResponse getCurrentUser(String email);

	public List<Roles> getPermissionAccess(String username);

	public Boolean isPermitted(String email, String url);

	public ResponseEntity<?> isPermitted(String email, String url, Boolean isGuard);

	public PermissionsAccess getSidenavPermissionAccess(String email);

	public Boolean resendOptForVerification(String regirterEmail,String fortype);
	public boolean channgePassword(ChangePasswordUtils changePasswordUtils,String email);
	
}
