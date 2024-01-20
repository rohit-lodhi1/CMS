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
public class CustomFieldValues {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	
	private String relatedToType;
	
	private Integer relatedToId;
	//many to one
	private Integer customFieldId;
	
	private String value;
	
	private boolean deleted;

}
