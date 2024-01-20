package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.payload.TicketTypeRequest;
import com.dollop.app.entity.payload.TicketTypeResponse;
import com.dollop.app.entity.payload.TicketsRequest;
import com.dollop.app.entity.payload.TicketsResponse;

public interface ITicketTypeService {

  	
	public TicketTypeResponse addTicketType(TicketTypeRequest ticketTypeRequest);
	
	public TicketTypeResponse updateTicketType(TicketTypeRequest ticketTypeRequest);
	
	public TicketTypeResponse getTicketTypeById(Integer id);
	
	public Page<TicketTypeResponse> getAllTicketTypeResponse(Integer pageNo,Integer pageSize);
	
	public Boolean deleteTicketType(Integer id);
	
	
	  public Page<TicketTypeResponse> searchTicketType(Integer pageNo,Integer pageSize,TicketTypeRequest ticketTypeRequest);
		
}
