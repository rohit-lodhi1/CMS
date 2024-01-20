package com.dollop.app.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.payload.ManageJobsRequest;
import com.dollop.app.entity.payload.ManageJobsResponse;

public interface IManageJobsService {

	public ManageJobsResponse addManageJobs(ManageJobsRequest manageJobsRequest);

	public ManageJobsResponse updateManageJobs(ManageJobsRequest manageJobsRequest);

	public ManageJobsResponse getManageJobsById(Integer id);

	public Page<ManageJobsResponse> getAllManageJobs(Integer pageNo, Integer pageSize);

	public Boolean deleteManageJobs(Integer id);

	public ManageJobsResponse updateManageJobsStatus(Integer id, String status, String ofType);
	
	public ManageJobsResponse updateManageJobType(Integer id, String status);
	public ResponseEntity<?> updateManageJobViews(Integer id);

	public Page<ManageJobsResponse> searchManageJobs(Integer pageNo, Integer pageSize, ManageJobsRequest manageJobsRequest);

	
	
	
}
