package com.dollop.app.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Termination;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.TerminationRequest;
import com.dollop.app.entity.payload.TerminationResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.TerminationRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.ITerminationService;

@Service
public class TerminationServiceImpl implements ITerminationService {

	@Autowired
	public TerminationRepository terminationRepository;

	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TerminationResponse terminationToTerminationResponse(Termination termination) {
		return this.modelMapper.map(termination, TerminationResponse.class);
	}

	public Termination terminationRequestToTermination(TerminationRequest terminationRequest) {
		return this.modelMapper.map(terminationRequest, Termination.class);
	}

	@Override
	public TerminationResponse addTermination(TerminationRequest terminationRequest) {
		Users user = this.usersRepository.findByIdAndDeleted(terminationRequest.getEmployee().getId(), false)
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.USER_NOT_FOUND + terminationRequest.getEmployee().getId()));
		if (user != null) {

			Termination terminationReques = this.terminationRequestToTermination(terminationRequest);
			user.setDeleted(true);
			this.usersRepository.save(user);
			return this.terminationToTerminationResponse(this.terminationRepository.save(terminationReques));
		}
		return null;
	}

	@Override
	public TerminationResponse updateTermination(TerminationRequest terminationRequest) {
		Termination terminationReque = this.terminationRepository.findById(terminationRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.TERMINATION_LIST_NOT_FOUND + terminationRequest.getId()));

		terminationReque.setDepartment(terminationRequest.getDepartment());
		
		terminationReque.setEmployee(terminationRequest.getEmployee());
		terminationReque.setIsDelete(terminationRequest.getIsDelete());
		terminationReque.setNoticeDate(terminationRequest.getNoticeDate());
		terminationReque.setReason(terminationRequest.getReason());
		terminationReque.setTerminationDate(terminationRequest.getTerminationDate());
		terminationReque.setTerminationType(terminationRequest.getTerminationType());

		return this.terminationToTerminationResponse(this.terminationRepository.save(terminationReque));

	}

	@Override
	public TerminationResponse getTerminationById(Integer id) {
		Termination terminationReques = this.terminationRepository.findByIdAndIsDelete(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TERMINATION_LIST_NOT_FOUND + id));
		return this.terminationToTerminationResponse(terminationReques);

	}

	@Override
	public Page<TerminationResponse> getAllTermination(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Termination> page = this.terminationRepository.findByIsDelete(pageRequest, false);

		return page.map(c -> this.terminationToTerminationResponse(c));

	}

	@Override
	public Boolean deleteTermination(Integer id) {
		Termination terminationReques = this.terminationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TERMINATION_LIST_NOT_FOUND + id));
		terminationReques.setIsDelete(true);
		this.terminationRepository.save(terminationReques);
		return true;
	}

	@Override
	public Page<TerminationResponse> searchTermination(Integer pageNo, Integer pageSize,
			TerminationRequest terminationRequest) {
		// goalList.setGoalType(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)))// for
				.withMatcher("goalType.id",
						match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

		Example<Termination> example = Example.of(this.terminationRequestToTermination(terminationRequest), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Termination> page = this.terminationRepository.findAll(example, pageable);

		return page.map(u -> this.terminationToTerminationResponse(u));
	}

}
