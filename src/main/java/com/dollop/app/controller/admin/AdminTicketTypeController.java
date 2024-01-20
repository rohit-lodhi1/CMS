package com.dollop.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.app.entity.payload.TicketTypeRequest;
import com.dollop.app.entity.payload.TicketTypeResponse;
import com.dollop.app.entity.payload.TicketsRequest;
import com.dollop.app.entity.payload.TicketsResponse;
import com.dollop.app.service.admin.ITicketTypeService;

@RestController
@RequestMapping("/rise/admin/ticketType")
@CrossOrigin("*")
public class AdminTicketTypeController {

	@Autowired
	private ITicketTypeService ticketTypeService;

	// add ticket type
	@PostMapping("/")
	public ResponseEntity<TicketTypeResponse> addTicketType(@RequestBody TicketTypeRequest ticketTypeRequest) {

		return new ResponseEntity<TicketTypeResponse>(this.ticketTypeService.addTicketType(ticketTypeRequest),
				HttpStatus.CREATED);
	}

	// update ticket type
	@PutMapping("/")
	public ResponseEntity<TicketTypeResponse> updateTicketType(@RequestBody TicketTypeRequest ticketTypeRequest) {

		return new ResponseEntity<TicketTypeResponse>(this.ticketTypeService.addTicketType(ticketTypeRequest),
				HttpStatus.OK);
	}

	// get all ticket type
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TicketTypeResponse>> getAllTicketType(@PathVariable Integer pageNo,@PathVariable Integer pageSize) {

		return new ResponseEntity<Page<TicketTypeResponse>>(this.ticketTypeService.getAllTicketTypeResponse(pageNo, pageSize),
				HttpStatus.OK);
	}
	
	// get ticket type by id
	@GetMapping("/{id}")
	public ResponseEntity<TicketTypeResponse> getTicketTypeById(@PathVariable Integer id) {

		return new ResponseEntity<TicketTypeResponse>(this.ticketTypeService.getTicketTypeById(id),
				HttpStatus.OK);
	}
	
	// delete ticket by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTicketType(@PathVariable Integer id) {

		return new ResponseEntity<Boolean>(this.ticketTypeService.deleteTicketType(id),
				HttpStatus.OK);
	}

	// filter searching
		@PostMapping("/search/{pageNo}/{pageSize}")
		public ResponseEntity<Page<TicketTypeResponse>> searchTicketType(@PathVariable Integer pageNo,
				@PathVariable Integer pageSize, @RequestBody TicketTypeRequest tickets) {
			Page<TicketTypeResponse> ticket = this.ticketTypeService.searchTicketType(pageNo, pageSize, tickets);
			return new ResponseEntity<Page<TicketTypeResponse>>(ticket, HttpStatus.OK);
		}
		
	
	
	
}
