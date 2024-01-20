package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.admin.LeaveStatics;

public interface ILeaveApplicationService {

	public LeaveApplicationResponse createApplication(LeaveApplicationRequest leaveApplication);
	
	public LeaveApplicationResponse updateLeaveApplication(LeaveApplicationRequest leaveApplication);
	
	public LeaveApplicationResponse updateLeaveApplicationStatus(String status,Integer id,String email);
	
	public Page<LeaveApplicationResponse> getAllLeaveApplication(Integer pageNo,Integer pageSize);
	
	public Page<LeaveApplicationResponse> getLeaveApplicationByStatus(Integer pageNo,Integer pageSize,String status);
	
	public Boolean deleteLeaveApplication(Integer id);
	
	public Page<LeaveApplicationResponse> searchLeaveApplication(Integer pageNo,Integer pageSize,LeaveApplicationRequest leaveApplications);
	
	public LeaveStatics getLeaveStatics();
}
