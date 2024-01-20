package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.CollectionNonStrictReadWriteAccess;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.entity.ModulePermissions;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.admin.ModulePermissionResponse;
import com.dollop.app.repository.ModulePermissionsRepository;
import com.dollop.app.repository.PermissionRepository;
import com.dollop.app.service.admin.IModulePermissionService;

@Service
public class ModulePermissionServiceImpl implements IModulePermissionService{

	@Autowired
	private ModulePermissionsRepository modulePermissionsRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	
	
	public ModulePermissionResponse modulePermissionToModulePermissionResponse(ModulePermissions m) {
		ModulePermissionResponse mr = new ModulePermissionResponse();
		mr.setId(m.getId());
		mr.setName(m.getName());
		mr.setPermissions(m.getPermissions());
		return mr;
	}
	
	public List<ModulePermissionResponse> updateModulePermissions(List<ModulePermissions> modules){
		List<ModulePermissions> all = this.modulePermissionsRepository.saveAll(modules);
		return all.parallelStream().map(p -> this.modulePermissionToModulePermissionResponse(p)).collect(Collectors.toList());
	}
	
	@Override
	public List<ModulePermissionResponse> getModulePermissionByRoleId(Integer id) {
		Roles r = new Roles();
		r.setId(id);
		List<ModulePermissions> permissions = this.modulePermissionsRepository.getModulePermissionByRoleId(id);

	   
	   permissions.parallelStream().forEach(p ->{
		  ;
		  
		   p.setPermissions(this.permissionRepository.findByModulePermissionsAndRole(p, r));
	   });

	   
	  return   permissions.parallelStream().map(p -> this.modulePermissionToModulePermissionResponse(p)).collect(Collectors.toList());
	
	}

}
