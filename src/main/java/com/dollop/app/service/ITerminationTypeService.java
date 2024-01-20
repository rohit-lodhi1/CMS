package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.GoalListResponse;
import com.dollop.app.entity.payload.TerminationTypeRequest;
import com.dollop.app.entity.payload.TerminationTypeResponse;

public interface ITerminationTypeService {

	public TerminationTypeResponse addTerminationType(TerminationTypeRequest terminationTypeRequest);

	public TerminationTypeResponse updateTermination(TerminationTypeRequest terminationTypeRequest);

	public Page<TerminationTypeResponse> getAllTerminationType(Integer pageNo, Integer pageSize);

	public TerminationTypeResponse getTerminationById(Integer id);

	public Boolean deleteTerminationById(Integer id);

}
