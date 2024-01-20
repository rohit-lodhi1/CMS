package com.dollop.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.AppliedCandidateRequest;
import com.dollop.app.entity.payload.AppliedCandidateResponse;
import com.dollop.app.entity.payload.ResignationResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.service.IAppliedCandidateService;
import com.dollop.app.service.admin.IProjectFilesService;

@RestController
@RequestMapping("/rise/admin/appliedCandidate")
@CrossOrigin("*")
public class AppliedCandidateController {

	@Autowired
	private IAppliedCandidateService candidateService;

	@PostMapping(path = "/create", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<AppliedCandidateResponse> createAppliedCandidate(
			@RequestPart(value = "files[]", required = false) MultipartFile file,
			@RequestPart("data") AppliedCandidateRequest appliedCandidateRequest) {
		return new ResponseEntity<AppliedCandidateResponse>(this.candidateService.addAppliedCandidate(appliedCandidateRequest, file),
				HttpStatus.CREATED);

	}

	

	// get all project
	@GetMapping("/{pageNo}/{pageSize}/{mId}")
	public ResponseEntity<Page<AppliedCandidateResponse>> getAllCandidates(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize,@PathVariable(name="mId") Integer mId) {
		Page<AppliedCandidateResponse> projects = this.candidateService.getAllAppliedCandidates(pageNo, pageSize,mId);

		ResponseEntity<Page<AppliedCandidateResponse>> response = new ResponseEntity<Page<AppliedCandidateResponse>>(projects,
				HttpStatus.OK);
		return response;
	}

	// get project by id
	@GetMapping("/{id}")
	public ResponseEntity<AppliedCandidateResponse> getCandidateById(@PathVariable Long id) {
		return new ResponseEntity<AppliedCandidateResponse>(this.candidateService.getAppliedCandidateById(id), HttpStatus.CREATED);
	}


	// update status by id
	@PutMapping("/status/{id}")
	public ResponseEntity<AppliedCandidateResponse> updateCandidateStatus(@RequestBody String status, @PathVariable Long id) {

		return new ResponseEntity<AppliedCandidateResponse>(this.candidateService.updateAppliedCandidateStatus(status, id), HttpStatus.OK);
	}


	// download Candidate resume file by id
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) {

		return this.candidateService.downloadFile(id);

	}

	
	
}
