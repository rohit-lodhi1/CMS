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
public class PaymentMethods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// colum text
	private String title;
	// colum text
	private String type;
	// colum  long text
	private String settings;
	
	private String description;
	
	private Boolean onlinePayable;
	
	private Boolean deleted;
	
	private Double minimumPaymentAmount;
	
	private boolean availableOnInvoice;
}