package com.dollop.app.entity.payload;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.InvoicesItems;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Taxes;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoicesRequest {
	private Integer id;
	private String iId;

	
	private Clients clientId;


	private Projects projectId;

	
	private Date billDate;
	
	private List<InvoicesItems> invoicesItems = new ArrayList<>();
	private Integer discountPercentage;
	private Date dueDate;
	// colum mtext
	private String note;
	
	private Date lastEmailSentDate;
	//enum
	private String status;
	
	private Taxes taxId;

	private Integer discount;
	private Long total;
	private Long grandTotal;
	 private Long paidAmount;

	private Long taxCost;
	
	private Boolean recurring;
	
	private Integer recurringInvoiceId;
	
	private Integer repeatEvery;
	//enum
	private String repeatType;
	
	private Integer noOfCycles;
	
	private Date nextRecurringDate;
	
	private Integer noOfCyclesCompleted;
	
	private Boolean deleted;

	public InvoicesRequest(String iId, Clients clientId, Projects projectId, Date billDate,
			List<InvoicesItems> invoicesItems, Integer discountPercentage, Date dueDate, String note,
			Date lastEmailSentDate, String status, Taxes taxId, Integer discount, Long total, Long grandTotal,
			Long paidAmount, Long taxCost, Boolean recurring, Integer recurringInvoiceId, Integer repeatEvery,
			String repeatType, Integer noOfCycles, Date nextRecurringDate, Integer noOfCyclesCompleted,
			Boolean deleted) {
		super();
		this.iId = iId;
		this.clientId = clientId;
		this.projectId = projectId;
		this.billDate = billDate;
		this.invoicesItems = invoicesItems;
		this.discountPercentage = discountPercentage;
		this.dueDate = dueDate;
		this.note = note;
		this.lastEmailSentDate = lastEmailSentDate;
		this.status = status;
		this.taxId = taxId;
		this.discount = discount;
		this.total = total;
		this.grandTotal = grandTotal;
		this.paidAmount = paidAmount;
		this.taxCost = taxCost;
		this.recurring = recurring;
		this.recurringInvoiceId = recurringInvoiceId;
		this.repeatEvery = repeatEvery;
		this.repeatType = repeatType;
		this.noOfCycles = noOfCycles;
		this.nextRecurringDate = nextRecurringDate;
		this.noOfCyclesCompleted = noOfCyclesCompleted;
		this.deleted = deleted;
	}
	

}
