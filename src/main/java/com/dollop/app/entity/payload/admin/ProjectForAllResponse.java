package com.dollop.app.entity.payload.admin;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.entity.payload.UsersResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectForAllResponse {
	private Integer id;

	private String title;

	private String description;

	private List<String> labels;

	private String starred_by;

	private Date deadline;

	private Date startDate;


	private Date createdDate;

	@JsonIgnoreProperties(value= {"owner"})
	private ClientsResponse clientId;

	private UsersResponse createdBy;

	private String status;

	private Double price;

	private String projectType;

	@JsonIgnoreProperties(value = {"projectId"})
	private List<ProjectMemberResponse> projectMembers;

	@JsonIgnoreProperties(value = {"projectId"})
	private List<ProjectFilesResponse> projectFiles;

	private List<CommentsResponse> projectComments;

	private Boolean deleted;
}
