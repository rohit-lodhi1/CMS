package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.DepartmentRequest;
import com.dollop.app.entity.payload.DepartmentResponse;
import com.dollop.app.entity.payload.DesignationRequest;
import com.dollop.app.entity.payload.DesignationResponse;

public interface IDesigntionService {
	
	public DesignationResponse createDesignation(DesignationRequest designation);

	
	public List<DesignationResponse> getAllDesignationByDepartment(Integer departmentId);

	public DesignationResponse getDesignationById(Integer designationId);

	public Boolean deleteDesignation(Integer designationId);
	
	public DesignationResponse updateDesignation(DesignationRequest designationRequest); 
	
	
	public Page<DesignationResponse> searchDesignation(Integer pageNo,Integer pageSize,DesignationRequest designationRequest);


}
