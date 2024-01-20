
package com.dollop.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaveTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	//enum
	private String status;
	// colum text
	private String title;

	private String description;

	

	private Boolean deleted;

}