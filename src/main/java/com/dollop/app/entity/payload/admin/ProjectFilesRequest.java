package com.dollop.app.entity.payload.admin;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.entity.payload.UsersRequest;
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
public class ProjectFilesRequest {
private Long id;
	
	private String originalName;
	
	private String description;
	
	private Double fileSize; 
	
	private Date createdAt;
	
	private ProjectRequest projectId;
	
	private String fileName;
	
	private UsersRequest uploadedBy;
	}
