package com.dollop.app.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EstimateItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	// colum text
	private String title;
	// colum text
	private String description;

	private Double quantity;

	private Double unitCost;

	private Double rate;

	private Double total;

	private Double grandTotal;

	@ManyToOne
	@JoinColumn(name = "estimate_id")
	private Estimates estimate;

	private Boolean deleted;

	public EstimateItems(Integer id, String title, String description, Double quantity, Double unitCost, Double total,
			Double grandTotal, Boolean deleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.quantity = quantity;
		this.unitCost = unitCost;
		this.total = total;
		this.grandTotal = grandTotal;
		this.deleted = deleted;
	}


}
