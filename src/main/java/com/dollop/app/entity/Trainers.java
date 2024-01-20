package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@NoArgsConstructor

public class Trainers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String description;
	private String status;
	private String email;
	private String phone;
	@ManyToOne
	private Designation role;
	
	private Boolean isDeleted=false;

	public Trainers(Integer id, String firstName, String lastName, String description, String status, String email,
			String phone,Designation role,  Boolean isDeleted) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.status = status;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.isDeleted = isDeleted;
	}

}
