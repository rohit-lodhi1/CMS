package com.dollop.app.entity.payload.admin;

import java.time.LocalDate;
import java.util.Map;

import com.dollop.app.entity.payload.UsersResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAttendanceResponse {

	private UsersResponse user;
	
	private Map<LocalDate, Boolean> userAttendance;
	
}
