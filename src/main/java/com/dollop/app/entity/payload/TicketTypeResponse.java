package com.dollop.app.entity.payload;

import java.util.List;

import com.dollop.app.entity.Tickets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypeResponse {

	private Integer id;

	private String title;
	
	private String description;
	
	private List<TicketsResponse> tickets;
	
	private Boolean isDeleted;
}
