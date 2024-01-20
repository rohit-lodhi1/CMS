package com.dollop.app.entity.payload;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.InvoicesItems;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Taxes;
import com.dollop.app.entity.Users;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvoicesResponse {
	private Integer id;
	private String iId;

	
	private Clients clientId;


	private Projects projectId;
	 private Long paidAmount;

	
	private Date billDate;
	
	
	private List<InvoicesItems> invoicesItems = new ArrayList<>();
	
	private Date dueDate;
	// colum mtext
	private String note;
	
	private Date lastEmailSentDate;
	//enum
	private Integer discountPercentage;
	private String status;
	
	
	private Taxes taxId;

	private Integer discount;
	private Long total;
	private Long grandTotal;
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


}
