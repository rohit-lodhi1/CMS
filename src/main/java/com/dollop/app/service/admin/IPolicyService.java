package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.admin.PolicyRequest;
import com.dollop.app.entity.payload.admin.PolicyResponse;

public interface IPolicyService {
 
	public PolicyResponse addPolicy(List<MultipartFile> files,PolicyRequest policy);
	
	public PolicyResponse updatePolicy(List<MultipartFile> files,PolicyRequest policyRequest); 
	
	public PolicyResponse getPolicyById(Integer id);
	
	public Page<PolicyResponse> getAllPolicy(Integer pageNo,Integer pageSize);
	
	public ResponseEntity<Resource> downloadFile(Integer id);
	
	public Boolean deletePolicyById(Integer id);
}
