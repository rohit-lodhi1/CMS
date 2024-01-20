package com.dollop.app.entity.payload.admin;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMemberRequest {
private Long id;
	
	private Projects projectId;
	
	
	private Users userId;
	
	private Boolean isLeader;
	 
	private Boolean deleted=false;
}
