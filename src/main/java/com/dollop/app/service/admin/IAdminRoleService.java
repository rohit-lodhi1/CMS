package com.dollop.app.service.admin;

import java.util.List;

import com.dollop.app.entity.payload.admin.AdminRoleRequest;
import com.dollop.app.entity.payload.admin.AdminRoleResponse;

public interface IAdminRoleService {

	public AdminRoleResponse  addRole(AdminRoleRequest request);
	
	public AdminRoleResponse  updateRole(AdminRoleRequest request);
	
	public AdminRoleResponse  getRole(Integer id);
	
	public Boolean deleteRoleById(Integer id);
	
	public List<AdminRoleResponse>  getAllRoles();
	
	
	
	
}
