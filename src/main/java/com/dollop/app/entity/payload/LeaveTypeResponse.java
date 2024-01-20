package com.dollop.app.entity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveTypeResponse {
	
	private Integer id;
	//enum
	private String status;
	// colum text
	private String title;

	private String description;

	
	private Boolean deleted;
}
