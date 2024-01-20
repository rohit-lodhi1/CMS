package com.dollop.app.entity.payload.admin;

import java.time.LocalDateTime;
import java.util.List;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.TasksResponse;
import com.dollop.app.entity.payload.UsersResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsResponse {

	private Long id;

	private UsersResponse createdBy;

	// @JsonIgnoreProperties(value= {"projectComments"})
	private ProjectResponse projectId;

	private TasksResponse taskId;

	// @JsonIgnoreProperties(value= {"projectId"})
	private List<ProjectFiles> fileId;
	// @JsonIgnoreProperties(value= {"projectId"})
	private List<ProjectFiles> images;

	private Integer customerFeedbackId;

	private String description;

	private LocalDateTime createdAt;

	private Boolean deleted;

	private String type;

}
