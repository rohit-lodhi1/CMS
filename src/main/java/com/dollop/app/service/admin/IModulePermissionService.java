package com.dollop.app.service.admin;

import java.util.List;
import com.dollop.app.entity.payload.admin.ModulePermissionResponse;

public interface IModulePermissionService {

	 List<ModulePermissionResponse>  getModulePermissionByRoleId(Integer id);
}
