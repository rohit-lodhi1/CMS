package com.dollop.app.entity.payload.admin;

import java.util.Date;

import com.dollop.app.entity.payload.UsersRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketsFileResponce {
  private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	private ProjectRequest projectId;
	
	private String fileName;
	
	private UsersRequest uploadedBy;

}
