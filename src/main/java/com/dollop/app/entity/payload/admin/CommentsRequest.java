package com.dollop.app.entity.payload.admin;

import java.util.List;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.TasksRequest;
import com.dollop.app.entity.payload.UsersRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsRequest {

	private Integer userId; 

	private Integer projectId;

	private Long taskId;

	@JsonIgnoreProperties(value = { "projectId" })
	private List<ProjectFiles> fileId;

	private Integer customerFeedbackId;

	private String description;

//	private Timestamp createdAt;

	private Boolean deleted;
	private String type;
}


