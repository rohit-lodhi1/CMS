package com.dollop.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Estimates {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String eid;

	@ManyToOne
	private Clients clientId;

	@ManyToOne
	private Projects projectId;

	@CreationTimestamp
	private Date billDate;

	private Date dueDate;
	// colum mtext
	private String note;

	private Date lastEmailSentDate;
	// enum
	private String status;
	@ManyToOne
	private Taxes taxeId;

	private Integer discount;
	private Integer discountPercentage;
	private Long total;
	private Long taxCost;
	private Long grandTotal;

	private Boolean deleted;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "estimate_id")
	@JsonIgnoreProperties(value = { "estimate" })
	private List<EstimateItems> estimateItems = new ArrayList<>();

}
