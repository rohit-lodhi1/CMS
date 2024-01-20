
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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String iId;

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
	private Taxes taxId;

	private Integer discount;
	private Integer discountPercentage;
	private Long total;
	private Long taxCost;
	 private Long grandTotal;
	 private Long paidAmount;
	

	private Boolean recurring;

	private Integer recurringInvoiceId;

	private Integer repeatEvery;
	// enum
	private String repeatType;

	private Integer noOfCycles;

	private Date nextRecurringDate;

	private Integer noOfCyclesCompleted;
   
	private Boolean deleted;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoices_id")
	@JsonIgnoreProperties(value={"invoices"})
	private List<InvoicesItems> invoicesItems = new ArrayList<>();

	


}
