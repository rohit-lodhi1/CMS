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

public class EstimatesResponse {
	private String id;
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
}
