package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.Tickets;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.entity.payload.TicketTypeRequest;
import com.dollop.app.entity.payload.TicketTypeResponse;
import com.dollop.app.repository.TicketTypeRepository;
import com.dollop.app.service.admin.ITicketTypeService;
import com.dollop.app.service.admin.ITicketsService;

@Service
public class TicketTypeServiceImpl implements ITicketTypeService {

	@Autowired
	private TicketTypeRepository ticketTypeRepository;
	
	
	
	@Autowired
	private ModelMapper modelMapper;

	public TicketTypeResponse ticketTypeToTicketTypeResponse(TicketTypes ticketTypes) {
		return this.modelMapper.map(ticketTypes, TicketTypeResponse.class);
	}

	public TicketTypes ticketTypeRequestToTicketType(TicketTypeRequest TicketTypesRequest) {
		return this.modelMapper.map(TicketTypesRequest, TicketTypes.class);
	}
	
	@Override
	public TicketTypeResponse addTicketType(TicketTypeRequest ticketTypeRequest) {
		TicketTypes ticketTypes = this.ticketTypeRepository.save(this.ticketTypeRequestToTicketType(ticketTypeRequest));
		return this.ticketTypeToTicketTypeResponse(ticketTypes);
	}

	@Override
	public TicketTypeResponse updateTicketType(TicketTypeRequest ticketTypeRequest) {
	          TicketTypes type = this.ticketTypeRepository.findById(ticketTypeRequest.getId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TICKET_TYPE_NOT_FOUND+ticketTypeRequest.getId()));
	          type.setTitle(ticketTypeRequest.getTitle());
	          type.setDescription(ticketTypeRequest.getDescription());
	    
	        return  this.ticketTypeToTicketTypeResponse( this.ticketTypeRepository.save(type));
		
	}

	@Override
	public TicketTypeResponse getTicketTypeById(Integer id) {
		 TicketTypes type = this.ticketTypeRepository.findByIdAndIsDeleted(id,false).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TICKET_TYPE_NOT_FOUND+id));
		 return  this.ticketTypeToTicketTypeResponse( this.ticketTypeRepository.save(type));
	}

	@Override
	public Page<TicketTypeResponse> getAllTicketTypeResponse(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<TicketTypes> page = this.ticketTypeRepository.findByIsDeleted(pageRequest,false);
		return page.map( t -> this.ticketTypeToTicketTypeResponse(t));
	}

	@Override
	public Boolean deleteTicketType(Integer id) {
		 TicketTypes type = this.ticketTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.TICKET_TYPE_NOT_FOUND+id));
		 type.setIsDeleted(true);
		 this.ticketTypeRepository.save(type);
		return true;
	}

	@Override
	public Page<TicketTypeResponse> searchTicketType(Integer pageNo, Integer pageSize,
			TicketTypeRequest ticketTypeRequest) {
	
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null :id)))// for
		.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null :id)));// for
				
		Example<TicketTypes> example = Example.of(this.ticketTypeRequestToTicketType(ticketTypeRequest), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<TicketTypes> page = this.ticketTypeRepository.findAll(example, pageable);

		return page.map(u -> this.ticketTypeToTicketTypeResponse(u));
	}

}
