package com.dollop.app.entity.payload.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAttendanceSearchRequest {

	private String name;
	
	private String month;
	
	private String year;
}
