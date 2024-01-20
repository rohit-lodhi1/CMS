package com.dollop.app.service;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.TerminationRequest;
import com.dollop.app.entity.payload.TerminationResponse;

public interface ITerminationService {

	public TerminationResponse addTermination(TerminationRequest terminationRequest);

	public TerminationResponse updateTermination(TerminationRequest terminationRequest);

	public TerminationResponse getTerminationById(Integer id);

	public Page<TerminationResponse> getAllTermination(Integer pageNo, Integer pageSize);

	public Boolean deleteTermination(Integer id);

	public Page<TerminationResponse> searchTermination(Integer pageNo, Integer pageSize,
			TerminationRequest terminationRequest);

}
