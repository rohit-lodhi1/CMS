package com.dollop.app.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department	department;
	
	private String description ;

	private Date createdAt;
	
	private boolean isDeleted;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="policy_id")
	private List<PolicyFiles> files;
	
	@PrePersist
	 public void prePersist() {
        createdAt  = new Date(System.currentTimeMillis()); // Set the current date before persisting
    }
		
}
