package com.dollop.app.entity.payload;

import java.sql.*;
import java.time.LocalDate;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSheetResponse {
	private  Integer id;

	private String assignedHours;

	private LocalDate timeSheetDate;
	
	private String hours;

	private String workedHours;

	public String description;

	private Users   user;

	private Projects projectId;
	
	private Tasks taskId;
	
	private Boolean deleted=false;

}
