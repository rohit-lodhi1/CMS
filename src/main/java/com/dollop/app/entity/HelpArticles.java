package com.dollop.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HelpArticles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	// colum text
	private String title;
	// colum longtext
	private String description;
	@ManyToOne
	private HelpCategories categoryId;
	
	private Integer createdBy;
	
	private Date createdAt;
	//enum
	private String status;
	
	private Integer totalViews;
	
	private Boolean deleted;

}
