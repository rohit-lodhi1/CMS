package com.dollop.app.service.admin;


import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.admin.AdminAttendanceSearchRequest;


public interface IAttendenceService {

	public Page<Object> getAttendance(Integer pageIndex,Integer pageSize);

	Page<Object> searchAttendances(Integer pageIndex, Integer pageSize, AdminAttendanceSearchRequest request);
}
