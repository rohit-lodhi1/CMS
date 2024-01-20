package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.TerminationType;
import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TerminationRequest {

private Integer id;
	
	
	private Users employee;
	
	
	private TerminationType terminationType;
	
	private String Department;
	
	private Date terminationDate;
	
	private Date noticeDate;
	
	private String Reason;
	
	private Boolean isDelete;

}
