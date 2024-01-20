package com.dollop.app.entity.payload;

import java.sql.Date;

import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.PaymentMethods;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class InvoicePaymentsResponse {

	
	private Integer id;

	private Long amount;
	
	private Date paymentDate;
	
	private PaymentMethods paymentMethodId;
	
	private String note;
	
	private String status;
	
	private Invoices invoiceId;
	private Boolean deleted;
	
	private String transactionId;
	
	private Integer createdBy;
	}
