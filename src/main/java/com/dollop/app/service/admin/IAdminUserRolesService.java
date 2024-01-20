package com.dollop.app.service.admin;

import java.util.List;

import com.dollop.app.entity.payload.admin.UserRoleRequest;
import com.dollop.app.entity.payload.admin.UserRoleResponse;

public interface IAdminUserRolesService {

	public UserRoleResponse addUserRole(UserRoleRequest userRole);
	public UserRoleResponse updateUserRole(UserRoleRequest userRole);
	public UserRoleResponse getUserRoleById(Integer id);
	public List<UserRoleResponse> getAllUserRole();
	public Boolean deleteUserRole(Integer id);
	public List<UserRoleResponse> getUserRolesOfUser(Integer id);
	
}
