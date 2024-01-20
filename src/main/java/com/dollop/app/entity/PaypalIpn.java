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
public class PaypalIpn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  
	private Integer id;
	// colum tenty text
	private String transactionId;
	// colum  longtext
	private String ipnHash;
	// colum longtext
	private String ipnData;
	
	private Boolean deleted;
}