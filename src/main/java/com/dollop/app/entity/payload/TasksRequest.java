package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Milestones;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksRequest {
	private Long id;

	private String title;

	private String description;
	
	private Integer hours;

	private List<String> Tasklabels;

	private Boolean deleted;

	private Date startDate;

	private Date deadline;
	// enum
	private String status;

	private String points;

	private Projects projectId;

//	@ManyToOne
//	private Milestones milestoneId;
	private Users assignedTo;

	private List<Users> collaborators;

}
