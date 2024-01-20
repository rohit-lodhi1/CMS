package com.dollop.app.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import lombok.ToString;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	private String title;


	
	@OneToMany
	@JsonIgnoreProperties(value= {"designation"})
	private List<PerformanceIndicator> performanceIndicator;


	@ManyToOne
	@JoinColumn(name = "departmentId")
	@JsonIgnoreProperties(value={"designations","description","isDeleted","isActive"})
	private Department department;
	
	@OneToMany
	@JoinColumn(name = "designationId")
	@JsonIgnore
	private List<Users> users;

	private Boolean isDeleted=false;


	public Designation(Integer id, String title, Boolean isDeleted) {
		super();
		this.id = id;
		this.title = title;
		this.isDeleted = isDeleted;
	}

}
