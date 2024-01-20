package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResignationRequest {
		
	private Integer id;

		
		private Users employee;
		
		private String reason;
		
		private Boolean isDelete;
		
		private Date noticeDate;
		
		private Date resigning;
		
		private String department;
}
