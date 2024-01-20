package com.dollop.app.utils;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.PermissionRepository;
import com.dollop.app.repository.UsersRepository;

@Component(value = "permissionEvaluator")
public class PreAuthorize {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	
	public boolean isAccessible(String url,String email) {
		Users user = this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND+email));
		Set<UserRoles> userRoles = user.getUserRoles();
		for (UserRoles u : userRoles) {

			Roles role = u.getRoles();
			List<Permissions> permissions = this.permissionRepository.findByRole(role);
			for (Permissions p : permissions) {

				if (p.getTitle().toLowerCase().contains(url.toLowerCase()) && p.getIsWriteable())
					return true;

			}

		}
		
		
		return false;
	}
}
