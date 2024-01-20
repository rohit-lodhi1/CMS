package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResignationResponse {
	private Integer id;

	
	private Users employee;
	
	private String reason;
	
	private Date noticeDate;
	
	private Date resigning;
	
	private String department;
	
	private Boolean isDelete;
}
