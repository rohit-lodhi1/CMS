package com.dollop.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.admin.PolicyRequest;
import com.dollop.app.entity.payload.admin.PolicyResponse;
import com.dollop.app.service.admin.IPolicyService;

import lombok.Delegate;

@RestController
@RequestMapping("/rise/admin/policy")
@CrossOrigin("*")
public class AdminPolicyController {

	@Autowired
	private IPolicyService policyService;
	
	@PostMapping(path = "/", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<PolicyResponse> addPolicy(@RequestPart("files[]")List<MultipartFile> files,@RequestPart("data") PolicyRequest policy){
		ResponseEntity<PolicyResponse> response = new ResponseEntity<PolicyResponse>(this.policyService.addPolicy(files, policy),HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<PolicyResponse> updatePolicy(@RequestPart(value = "files[]",required = false)List<MultipartFile> files,@RequestPart("data") PolicyRequest policy){
		ResponseEntity<PolicyResponse> response = new ResponseEntity<PolicyResponse>(this.policyService.updatePolicy(files, policy),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PolicyResponse> getPolicyById(@PathVariable Integer id){
		ResponseEntity<PolicyResponse> response = new ResponseEntity<PolicyResponse>(this.policyService.getPolicyById(id),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<PolicyResponse>> getAllPolicies(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		ResponseEntity<Page<PolicyResponse>> response = new ResponseEntity<Page<PolicyResponse>>(this.policyService.getAllPolicy(pageNo,pageSize),HttpStatus.OK);
		
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deletePolicyById(@PathVariable Integer id){
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(this.policyService.deletePolicyById(id),HttpStatus.ACCEPTED);
		return response;
	}
	
	
}
