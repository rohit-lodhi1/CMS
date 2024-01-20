package com.dollop.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Leaves {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate date;
	
	@ManyToOne
	private Users employee;
	
}
