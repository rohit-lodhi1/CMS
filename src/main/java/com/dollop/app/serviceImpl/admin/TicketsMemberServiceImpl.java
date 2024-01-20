package com.dollop.app.serviceImpl.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tickets;
import com.dollop.app.entity.TicketsMembers;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.admin.ProjectMemberRequest;
import com.dollop.app.entity.payload.admin.ProjectMemberResponse;
import com.dollop.app.entity.payload.admin.TicketsMemberRequest;
import com.dollop.app.entity.payload.admin.TicketsMemberResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.TicketsMemberRepository;
import com.dollop.app.service.admin.ITicketsMemberService;

@Service
public class TicketsMemberServiceImpl implements ITicketsMemberService {

	@Autowired
	private TicketsMemberRepository ticketsMemberRepository;
	@Autowired
	private ModelMapper modelMapper;

	public TicketsMemberResponse ticketsMembertoTicketMemberResponse(TicketsMembers ticketsMembers) {
		return this.modelMapper.map(ticketsMembers, TicketsMemberResponse.class);
	}

	public TicketsMembers ticketMemberRequestToTicketMember(TicketsMemberRequest ticketsMemberRequest) {
		return this.modelMapper.map(ticketsMemberRequest, TicketsMembers.class);
	}

	@Override
	public List<TicketsMemberResponse> addTicketsMember(List<TicketsMemberRequest> memberRequest) {
		List<TicketsMembers> list = memberRequest.stream().map(m -> this.ticketMemberRequestToTicketMember(m))
				.collect(Collectors.toList());
		List<TicketsMembers> ticketsMembers = new ArrayList<>();
		for (TicketsMembers l : list) {
			Tickets t = new Tickets();
			t.setId(l.getTickets().getId());
			Users employee = new Users();
			employee.setId(l.getFollowers().getId());
			Optional<TicketsMembers> memb = this.ticketsMemberRepository.findByTicketsAndFollowers(t, employee);
			if (memb.isEmpty())
				ticketsMembers.add(l);
		}
		ticketsMembers = this.ticketsMemberRepository.saveAll(ticketsMembers);
		return ticketsMembers.stream().map(m -> this.ticketsMembertoTicketMemberResponse(m))
				.collect(Collectors.toList());
	}

	@Override
	public TicketsMemberResponse updateTicketsMember(TicketsMemberRequest memberRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketsMemberResponse getTicketsMemberById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TicketsMemberResponse> getTicketsMemberByTicketId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Tickets t = new Tickets();
		t.setId(id);
		Page<TicketsMembers> members = this.ticketsMemberRepository.findByTickets(pageRequest, t);

		return members.map(m -> this.ticketsMembertoTicketMemberResponse(m));
	}

	@Override
	public Page<TicketsMemberResponse> getTicketsMemberByUserId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Users user = new Users();
		user.setId(id);
		Page<TicketsMembers> members = this.ticketsMemberRepository.findByFollowers(pageRequest, user);
		return members.map(m -> this.ticketsMembertoTicketMemberResponse(m));
	}

	@Override
	public Boolean deleteTicketsMember(Long id) {
		TicketsMembers member = this.ticketsMemberRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TICKET_MEMBER_NOT_FOUND + id));
		this.ticketsMemberRepository.delete(member);
		return true;
	}

	@Override
	public TicketsMemberResponse makeLeaderForTicket(TicketsMemberRequest memberRequest) {
		Tickets t = new Tickets();
		t.setId(memberRequest.getTickets().getId());
		Users employee = new Users();
		employee.setId(memberRequest.getFollowers().getId());
		TicketsMembers tm = this.ticketsMemberRepository.findByTicketsAndFollowers(t, employee)
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.TICKET_MEMBER_NOT_FOUND + memberRequest.getTickets().getId() + " and user id :"
								+ memberRequest.getFollowers().getId()));
		tm.setIsLeader(memberRequest.getIsLeader());
		tm = this.ticketsMemberRepository.save(tm);
		return this.ticketsMembertoTicketMemberResponse(tm);
	}

	

}
