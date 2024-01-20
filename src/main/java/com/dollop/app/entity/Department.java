package com.dollop.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId")
	@JsonIgnoreProperties(value={"department"})
	private List<Designation> designations;
	
	private Boolean isActive=true;
	
	private Boolean isDeleted=false;
	
	@ManyToOne
	@JoinColumn(name = "manageJobsId ")
	@JsonIgnore
	private ManageJobs manageJobs;

	public Department(Integer id, String title, String description, List<Designation> designations, Boolean isDeleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.designations = designations;
		this.isDeleted = isDeleted;
	}
	
	
	

}
