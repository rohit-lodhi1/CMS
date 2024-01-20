package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.DepartmentRequest;
import com.dollop.app.entity.payload.DepartmentResponse;

public interface IDepartmentService {

	public DepartmentResponse createDepartment(DepartmentRequest department);

	public DepartmentResponse updateDepartment(DepartmentRequest department);

	public DepartmentResponse getDepartmentById(Integer departmentId);

	public List<DepartmentResponse> getAllDeparments();

	public Boolean deleteDepartment(Integer id);
	
	public Page<DepartmentResponse> searchDepartment(Integer pageNo,Integer pageSize,DepartmentRequest departmentRequest);

}
