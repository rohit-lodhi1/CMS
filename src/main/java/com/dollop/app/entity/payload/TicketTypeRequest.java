package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Tickets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeRequest {

	private Integer id;

	private String title;
	
	private String description;
	
	private List<TicketsRequest> tickets;
	
	private Boolean isDeleted;

}
