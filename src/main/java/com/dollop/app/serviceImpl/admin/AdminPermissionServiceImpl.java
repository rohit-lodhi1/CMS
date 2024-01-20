package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.entity.ModulePermissions;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.admin.AdminPermissionResponse;
import com.dollop.app.repository.PermissionRepository;
import com.dollop.app.service.admin.IAdminPermissionService;

@Service
public class AdminPermissionServiceImpl implements IAdminPermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public AdminPermissionResponse permissionToAdminPermssionResponse(Permissions permission) {
		return this.mapper.map(permission, AdminPermissionResponse.class);
	}
	
	@Override
	public  List<AdminPermissionResponse> updatePermissions(List<Permissions> permissions){ 
		List<Permissions> list = this.permissionRepository.saveAll(permissions);
		return list.stream().map(p -> this.permissionToAdminPermssionResponse(p)).collect(Collectors.toList());
	}
	
	
	@Override
	public List<AdminPermissionResponse> getPermissionOfRoleByRoleId(Integer id) {
   Roles role = new Roles();
   role.setId(id);
   List<Permissions> permission = this.permissionRepository.findByRole(role);
		return permission.stream().map(p -> this.permissionToAdminPermssionResponse(p)).collect(Collectors.toList());
	}

	@Override
	public AdminPermissionResponse getPermissionByTitleContaining(String title) {
	      Permissions permissions = this.permissionRepository.findByTitleContaining(title).orElse(null);
		return this.permissionToAdminPermssionResponse(permissions);
	}
	
	
	
	public List<ModulePermissions> getPermissionsByRole(Integer id){
		Roles role = new Roles();
		   role.setId(id);
		List<Permissions> roles = this.permissionRepository.findByRole(role);
		Map<ModulePermissions, List<Permissions>> list = roles.stream().collect(Collectors.groupingBy(a -> a.getModulePermissions()));
	
		return null;
	}

}
