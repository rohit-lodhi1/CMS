package com.dollop.app.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InvoicePayments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Long amount;
	
	private Date paymentDate;
	
	@ManyToOne
	private PaymentMethods paymentMethodId;
	
	private String note;
	
	private String status;
	
	@OneToOne
	private Invoices invoiceId;
	
	
	private Boolean deleted=false;
	
	private String transactionId;
	
	private Integer createdBy;
	

}
