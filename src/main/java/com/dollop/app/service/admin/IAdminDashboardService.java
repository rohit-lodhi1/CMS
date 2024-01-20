package com.dollop.app.service.admin;

import java.util.List;

import com.dollop.app.entity.payload.admin.AdminDashBoardResponse;

public interface IAdminDashboardService {
	public AdminDashBoardResponse fetchDetails();

	public Object fetchTaskDetailsForAdminDash();
	
	
	public List<Object[]> fetchBarChartData();

	public List<Object[]> fetchAdminDashBoardOverAllStatics();

}
