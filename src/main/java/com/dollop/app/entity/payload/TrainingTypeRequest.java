package com.dollop.app.entity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingTypeRequest {
	
	private Integer id;
	
private String description;
	
	private String type;
	
	private String status;
	
	private Boolean isDelete;
	
}
