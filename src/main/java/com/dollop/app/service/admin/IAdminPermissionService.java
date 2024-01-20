package com.dollop.app.service.admin;

import java.util.List;

import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.payload.admin.AdminPermissionResponse;

public interface IAdminPermissionService {

	List<AdminPermissionResponse> getPermissionOfRoleByRoleId(Integer id);
	
	AdminPermissionResponse getPermissionByTitleContaining(String title);
    List<AdminPermissionResponse> updatePermissions(List<Permissions> permissions);
}
