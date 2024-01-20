
package com.dollop.app.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Projects {
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String description;
	
	@ElementCollection
	@CollectionTable(name = "project_labels")
	@Column(name="project_label")

	private List<String> labels;
	
	private String starred_by;
	
	private Date deadline;
	
	private Date startDate;
	
	
	private Date createdDate;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="projectId")
	@JsonIgnoreProperties(value= {"projectId"})
	private List<Tasks> tasks= new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdDate  = new Date(System.currentTimeMillis()); // Set the current date before persisting
    }
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Clients clientId;
	
	@ManyToOne
	private Users createdBy;
	
	private String status;
	
	private Double price;
	
	private String projectType;
	
	private String priority;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="project_id_id")
	@JsonIgnoreProperties(value = {"projectId"})	
	private List<ProjectMembers> projectMembers;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="project_id_id")
	@JsonIgnoreProperties(value = {"projectId"})
	private List<ProjectFiles> projectFiles;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="project_id_id")
	@JsonIgnoreProperties(value = {"projectId"})
	private List<Comments> projectComments;
	
	private Boolean deleted;
	
	
}