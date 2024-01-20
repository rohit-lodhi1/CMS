package com.dollop.app.service.employee;

import java.util.List;
import com.dollop.app.entity.payload.LeaveTypeRequest;
import com.dollop.app.entity.payload.LeaveTypeResponse;

public interface ILeaveTypeService {

	public List<LeaveTypeResponse> getAllLeaveTypes();
	
	public List<LeaveTypeResponse> getAllLeaveTypesActive();
	public LeaveTypeResponse getLeaveTypeById(Integer id);

}
