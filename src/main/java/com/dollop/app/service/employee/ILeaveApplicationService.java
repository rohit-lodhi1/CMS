package com.dollop.app.service.employee;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.employee.EmployeeLeaveStatics;

public interface ILeaveApplicationService {

	public LeaveApplicationResponse createApplication(LeaveApplicationRequest leaveApplication,String email);
	
	public LeaveApplicationResponse updateLeaveApplication(LeaveApplicationRequest leaveApplication);
	
	public LeaveApplicationResponse getLeaveApplicationById(Integer id);
	
	public Page<LeaveApplicationResponse> getLeaveApplicationByApplicantId(Integer pageNo,Integer pageSize,String email);
	
	public Page<LeaveApplicationResponse> getLeaveApplicationByTypeId(Integer pageNo,Integer pageSize,Integer id);
	
	public Boolean deleteLeaveApplication(Integer id);

	public EmployeeLeaveStatics getLeaveStatics(String email);
	
}
