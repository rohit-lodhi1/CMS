package com.dollop.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.admin.ModulePermissionResponse;
import com.dollop.app.service.admin.IModulePermissionService;

@RestController
@RequestMapping("/rise/admin/module")
@CrossOrigin("*")
public class ModulePermissionsController {

	@Autowired
	private IModulePermissionService modulePermissionService;
	
	@GetMapping("/permission/{id}")
	public ResponseEntity<List<ModulePermissionResponse>> getModulePermissionByRoleId(@PathVariable Integer id){
		return new ResponseEntity<List<ModulePermissionResponse>>(this.modulePermissionService.getModulePermissionByRoleId(id),HttpStatus.OK);
	}
}
