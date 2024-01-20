package com.dollop.app.entity.payload.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveStatics {
	private Integer totalPresent;
	private Integer totalEmployee;
	
	private Integer plannedLeaves;
	
	private Integer unplannedLeaved;
	private Integer  pendingRequests;

}
