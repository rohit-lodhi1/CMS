package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.EstimatesRequest;
import com.dollop.app.entity.payload.EstimatesResponse;

public interface IEstimatesService {
	
	
	public EstimatesResponse addEstimates(EstimatesRequest estimates);

	public EstimatesResponse updateEstimates(EstimatesRequest estimates);
	
	public Page<EstimatesResponse> getAllEstimates(Integer pageNo, Integer pageSize);

	public Boolean deleteEstimates(Integer id);
	
	public Page<EstimatesResponse> searchEstimates(Integer pageNo, Integer pageSize, EstimatesRequest estimates);

	EstimatesResponse getEstimatesById(Integer id);


}
