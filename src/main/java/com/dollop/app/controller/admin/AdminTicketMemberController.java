package com.dollop.app.controller.admin;

import java.util.List;

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

import com.dollop.app.entity.payload.admin.TicketsMemberRequest;
import com.dollop.app.entity.payload.admin.TicketsMemberResponse;
import com.dollop.app.service.admin.ITicketsMemberService;

@RestController
@RequestMapping("/rise/admin/ticketsMember")
@CrossOrigin("*")
public class AdminTicketMemberController {

	@Autowired
	private ITicketsMemberService iTicketsMemberService;

	// add ticket member
	@PostMapping("/")
	public ResponseEntity<List<TicketsMemberResponse>> addTicketMember(
			@RequestBody List<TicketsMemberRequest> memberRequest) {
		return new ResponseEntity<List<TicketsMemberResponse>>(
				this.iTicketsMemberService.addTicketsMember(memberRequest), HttpStatus.CREATED);
	}

	// update ticket member
	@PutMapping("/")
	public ResponseEntity<TicketsMemberResponse> updateTicketMember(@RequestBody TicketsMemberRequest memberRequest) {
		return new ResponseEntity<TicketsMemberResponse>(this.iTicketsMemberService.updateTicketsMember(memberRequest),
				HttpStatus.CREATED);
	}

	// get ticket member by id
	@GetMapping("/{id}")
	public ResponseEntity<TicketsMemberResponse> getTicketMemberById(@PathVariable Long id) {
		return new ResponseEntity<TicketsMemberResponse>(this.iTicketsMemberService.getTicketsMemberById(id),
				HttpStatus.CREATED);
	}

//	// get all ticket members
//		@GetMapping("/{pageNo}/{pageSize}")
//		public ResponseEntity<Page<TicketsMemberResponse>> getAllTicketMembers(@PathVariable Integer pageNo,
//																						@PathVariable Integer pageSize) {
//			return new ResponseEntity<Page<TicketsMemberResponse>>(this.iTicketsMemberService.get(pageNo, pageSize),
//					HttpStatus.OK);
//		}

	// get ticket members by project id
	@GetMapping("/tickets/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<TicketsMemberResponse>> getTicketMembersByProjectId(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable Integer id) {
		return new ResponseEntity<Page<TicketsMemberResponse>>(
				this.iTicketsMemberService.getTicketsMemberByTicketId(pageNo, pageSize, id), HttpStatus.OK);
	}

	// get ticket members by project id
	@GetMapping("/user/{pageNo}/{pageSize}/{id}")
	public ResponseEntity<Page<TicketsMemberResponse>> getTicketMemberByUserId(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize, @PathVariable Integer id) {
		return new ResponseEntity<Page<TicketsMemberResponse>>(
				this.iTicketsMemberService.getTicketsMemberByUserId(pageNo, pageSize, id), HttpStatus.OK);
	}

	// mark ticket member as leader
	@PutMapping("/leader")
	public ResponseEntity<TicketsMemberResponse> markTicketMemberLeader(
			@RequestBody TicketsMemberRequest memberRequest) {
		return new ResponseEntity<TicketsMemberResponse>(this.iTicketsMemberService.makeLeaderForTicket(memberRequest),
				HttpStatus.CREATED);
	}

	// delete ticket member by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTicketMemberById(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.iTicketsMemberService.deleteTicketsMember(id), HttpStatus.ACCEPTED);
	}
}
