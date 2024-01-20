package com.dollop.app.entity;

import java.util.Date;

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
public class Posts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer createdBy;
	
	private Date createdAt;
	// colum mtext
	private String description;
	// colum text
	private String shareWith;
	// colum  long text
	private String files;
	
	private Integer postId;
	
	private Boolean deleted;
}