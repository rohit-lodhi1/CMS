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
public class CustomFields {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;

	private String title;

	private String placeholder;

	//mediumtext
	private String options;

	private String fieldType;

	private String relatedTo;

	private Integer sort;

	private Boolean required;

	private Boolean showInTable;

	private Boolean showInInvoice;

	private Boolean visibleToAdminsOnly;
	
	private Boolean hideFromClients;

	private Boolean deleted;

}
