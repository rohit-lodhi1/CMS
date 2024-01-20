package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.StaffSalaryRequest;
import com.dollop.app.entity.payload.StaffSalaryResponse;

public interface IStaffSalaryService {
	
	
	public StaffSalaryResponse addStaffSalary(StaffSalaryRequest staffSalary); 
	   
	   public StaffSalaryResponse getStaffSalaryById(Integer id);
	   
	   public StaffSalaryResponse updateStaffSalary(StaffSalaryRequest trainers);
	   
	   public Page<StaffSalaryResponse> getAllStaffSalary(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteStaffSalary(Integer id);
	   
	   
	   public Page<StaffSalaryResponse> searchStaffSalary(Integer pageNo, Integer pageSize, StaffSalaryRequest StaffSalaryRequest);

	

}
