
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
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

	private Integer createdBy;

	private Date createdAt;

	// colum text
	private String title;

	// colum text
	private String description;

	@ManyToOne
	private Projects projectId;

	@ManyToOne
	private Clients clientId;

	@ManyToOne
	private Users userId;

	private String tables;

	private Boolean deleted;

}
