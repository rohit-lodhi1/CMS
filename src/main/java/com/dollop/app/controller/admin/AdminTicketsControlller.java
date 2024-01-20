
package com.dollop.app.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dollop.app.entity.payload.TicketsRequest;
import com.dollop.app.entity.payload.TicketsResponse;
import com.dollop.app.service.admin.ITicketsService;

@RestController
@RequestMapping("/rise/admin/tickets")
@CrossOrigin("*")

public class AdminTicketsControlller {

	@Autowired
	private ITicketsService ticketsService;
	
	
	@PostMapping(path = "/create", consumes = { "multipart/form-data", "application/octet-stream" })
	public ResponseEntity<TicketsResponse> createProject(
			@RequestPart(value = "files[]", required = false) List<MultipartFile> file,
			@RequestPart("data") TicketsRequest ticketsRequest,Principal principal) {
               
		return new ResponseEntity<TicketsResponse>(this.ticketsService.addTickets(ticketsRequest, file,principal.getName()),
				HttpStatus.CREATED);

	}

	// update Tickets
	@PutMapping("/")
	public ResponseEntity<TicketsResponse> updatetickets(@RequestBody TicketsRequest ticketsRequest) {
		TicketsResponse updatetickets = this.ticketsService.updateTickets(ticketsRequest);
		return ResponseEntity.ok(updatetickets);
	}

	// get by id Tickets
	@GetMapping("/{ticketsId}")
	public ResponseEntity<TicketsResponse> getSingleUsers(@PathVariable Integer ticketsId) {

		return ResponseEntity.ok(this.ticketsService.getTicketsById(ticketsId));
	}
	
	// get by id Tickets
		@GetMapping("/statics")
		public ResponseEntity<?> getTicketStatics() {

			return this.ticketsService.getAllStaticsOfTickets();
		}

	// get all Tickets
	@GetMapping("/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TicketsResponse>> getAllUsers(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		return ResponseEntity.ok(this.ticketsService.getAllTickets(pageNo, pageSize));
	}

	// delete by tickets Id
	@DeleteMapping("/{ticketsId}")
	public ResponseEntity<Boolean> deletedTickets(@PathVariable Integer ticketsId) {

		return ResponseEntity.ok(ticketsService.deleteTickets(ticketsId));
	}

	// filter searching
	@PostMapping("/search/{pageNo}/{pageSize}")
	public ResponseEntity<Page<TicketsResponse>> searchTicket(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @RequestBody TicketsRequest tickets) {
		Page<TicketsResponse> ticket = this.ticketsService.searchTickets(pageNo, pageSize, tickets);
		return new ResponseEntity<Page<TicketsResponse>>(ticket, HttpStatus.OK);
	}
	
    
 // update update status by id
 	@GetMapping("/status/{status}/{id}/{oftype}")
 	public ResponseEntity<TicketsResponse> updateOverTimeStatus(@PathVariable Integer id,
 			                                                        @PathVariable String status,@PathVariable String oftype) {
 		TicketsResponse updateStatus = this.ticketsService.changeTicketsStatus(id, status,oftype);
 		return new ResponseEntity<TicketsResponse>(updateStatus, HttpStatus.OK);
 	}
 

	
	// download project file by id
		@GetMapping("/download/{id}")
		public ResponseEntity<Resource> downloadTicketFileImages(@PathVariable("id") Long id) {

			return this.ticketsService.downloadFile(id);

		}

		// delete project file by id
		@DeleteMapping("/deleteTicketFile/{id}")
		public ResponseEntity<Boolean> deleteTicketFiles(@PathVariable Long id) {
			return new ResponseEntity<Boolean>(this.ticketsService.deleteTicketFilesByTicketFileId(id), HttpStatus.ACCEPTED);
		}



}
