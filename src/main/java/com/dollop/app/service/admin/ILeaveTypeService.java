package com.dollop.app.service.admin;

import com.dollop.app.entity.payload.LeaveTypeRequest;
import com.dollop.app.entity.payload.LeaveTypeResponse;

public interface ILeaveTypeService {

	public LeaveTypeResponse addLeaveType(LeaveTypeRequest leaveType);

	public LeaveTypeResponse updateLeaveType(LeaveTypeRequest leaveType);

	public Boolean deleteLeaveTypeById(Integer id);

	public LeaveTypeResponse updateLeaveTypeStatus(Integer id, String status);

}
