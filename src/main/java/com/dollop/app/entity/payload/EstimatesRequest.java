package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.EstimateItems;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Taxes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstimatesRequest {

	private Integer id;
	private String eid;
	private Clients clientId;

	private Projects projectId;

	private Date billDate;


	private Date dueDate;
	// colum mtext
	private String note;

	private Date lastEmailSentDate;
	// enum
	private String status;
	private Taxes taxeId;

	private Integer discount;
	private Integer discountPercentage;

	private Long total;
	private Long taxCost;
	private Long grandTotal;
	   
	private Boolean deleted;
	private List<EstimateItems> estimateItems = new ArrayList<>();
	
	public EstimatesRequest(String eid, Clients clientId, Projects projectId, Date billDate, Date dueDate, String note,
			Date lastEmailSentDate, String status, Taxes taxeId, Integer discount, Integer discountPercentage,
			Long total, Long taxCost, Long grandTotal, Boolean deleted, List<EstimateItems> estimateItems) {
		super();
		this.eid = eid;
		this.clientId = clientId;
		this.projectId = projectId;
		this.billDate = billDate;
		this.dueDate = dueDate;
		this.note = note;
		this.lastEmailSentDate = lastEmailSentDate;
		this.status = status;
		this.taxeId = taxeId;
		this.discount = discount;
		this.discountPercentage = discountPercentage;
		this.total = total;
		this.taxCost = taxCost;
		this.grandTotal = grandTotal;
		this.deleted = deleted;
		this.estimateItems = estimateItems;
	}
	
	
}
