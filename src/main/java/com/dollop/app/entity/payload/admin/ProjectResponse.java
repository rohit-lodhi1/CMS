package com.dollop.app.entity.payload.admin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Comments;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.entity.payload.UsersResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {
	
private Integer id;
	
	private String title;
	private String priority;
	
	private String description;
	
	
	private List<String> labels;
	
	private String starred_by;
	
	private Date deadline;
	
	private Date startDate;
	
	
	private Date createdDate;
	
	@JsonIgnore
	private List<Tasks> tasks= new ArrayList<>();

    @JsonIgnoreProperties(value= {"owner"})
    private Clients clientId;
	
	private Users createdBy;
	
	private String status;
	
	private Double price;
	
	private String projectType;
	
	private List<ProjectMembers> projectMembers;
	
	private List<ProjectFiles> projectFiles;
	private List<ProjectFiles> images;
	
	private List<Comments> projectComments;
	
	private Boolean deleted;
}
