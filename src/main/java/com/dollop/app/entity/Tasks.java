package com.dollop.app.entity;


import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String title;
	
	private Integer hours;

	private String description;

	@CollectionTable(name = "Task_labels")
	@ElementCollection
	@Column(name = "Task_label")
	private List<String> Tasklabels;

	private Boolean deleted;

	private Date startDate;

	private Date deadline;
	// enum
	private String status;

	private String points;

	@ManyToOne
	@JoinColumn(name="projectId")
	@JsonIgnoreProperties(value= {"tasks"})
	private Projects projectId;

//	@ManyToOne
//	private Milestones milestoneId;

	@ManyToOne
	private Users assignedTo;

	@ManyToMany
	private List<Users> collaborators;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "task_id")
	private List<Comments> comments;

}