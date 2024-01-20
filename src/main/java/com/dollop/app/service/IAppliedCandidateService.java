package com.dollop.app.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.AppliedCandidateRequest;
import com.dollop.app.entity.payload.AppliedCandidateResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;

public interface IAppliedCandidateService {

				
	public AppliedCandidateResponse addAppliedCandidate(AppliedCandidateRequest appliedCandidateRequest,MultipartFile multi);
		
	public AppliedCandidateResponse getAppliedCandidateById(Long id);
	
	public Page<AppliedCandidateResponse> getAllAppliedCandidates(Integer pageNo,Integer pageSize,Integer mId);
	
	
	public AppliedCandidateResponse updateAppliedCandidateStatus(String status,Long id);

	ResponseEntity<Resource> downloadFile(Long id);
	
//	public Boolean deleteProject(Integer id);
	
	

}
