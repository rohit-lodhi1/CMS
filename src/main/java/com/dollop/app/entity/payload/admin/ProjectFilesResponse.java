package com.dollop.app.entity.payload.admin;

import java.util.Date;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectFilesResponse {
	
    private Long id;
	
	private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	@JsonIgnoreProperties(value = {"projectFiles"})
	private ProjectResponse projectId;
	
	private String fileName;
	
	private UsersResponse uploadedBy;
	 
	private Boolean deleted;
}
