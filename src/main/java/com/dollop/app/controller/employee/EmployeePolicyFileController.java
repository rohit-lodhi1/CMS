package com.dollop.app.controller.employee;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.service.employee.IPolicyFileService;

@RestController
@RequestMapping("/rise/employee/policyFile")
@CrossOrigin("*")
public class EmployeePolicyFileController {

	@Autowired
	private IPolicyFileService fileService;
	
	@GetMapping("/{id}")	
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id){
		return this.fileService.downloadFile(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePolicyFile(@PathVariable Long id){
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(this.fileService.deletePolicyFileById(id),HttpStatus.ACCEPTED);
		return response;
	}
	
}
