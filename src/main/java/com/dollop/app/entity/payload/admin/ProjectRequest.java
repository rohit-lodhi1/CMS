package com.dollop.app.entity.payload.admin;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.payload.ClientsRequest;
import com.dollop.app.entity.payload.UsersRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
	private Integer id;
	
	private String title;
	
	private String description;
	
	private String priority;
	
	private List<String> labels;
	
	private String starred_by;
	
	private Date deadline;
	
	private Date startDate;
	
	
	private Date createdDate;
	

	private List<Tasks> tasks;

	
	
	private ClientsRequest clientId;
	
	private UsersRequest createdBy;
	
	private String status;
	
	private Double price;
	
	private String projectType;
		
	private List<ProjectMemberRequest> projectMembers;
	
	private List<ProjectFilesRequest> projectFiles;

	private List<CommentsRequest> projectComments;
	
	private Boolean deleted;

}
