package com.dollop.app.serviceImpl.admin;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Estimates;
import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.payload.EstimatesRequest;
import com.dollop.app.entity.payload.EstimatesResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.EstimateItemRepository;
import com.dollop.app.repository.EstimatesRepository;

import com.dollop.app.service.admin.IEstimatesService;

@Service
public class EstimatesServiceImpl implements IEstimatesService {

	@Autowired
	public EstimatesRepository estimatesRepository;
	
	@Autowired
	public EstimateItemRepository estimatesItemRepository;

	@Autowired
	private ModelMapper modelMapper;

	public EstimatesResponse estimatesToEstimatesResponse(Estimates estimates) {
		return this.modelMapper.map(estimates, EstimatesResponse.class);
	}

	public Estimates ivoicesRequestToInvoices(EstimatesRequest EstimatesRequest) {
		return this.modelMapper.map(EstimatesRequest, Estimates.class);
	}

	@Override
	public EstimatesResponse addEstimates(EstimatesRequest estimates) {
		Estimates estimate = this.ivoicesRequestToInvoices(estimates);

		estimate.setEid(UUID.randomUUID().toString());

		return this.estimatesToEstimatesResponse(this.estimatesRepository.save(estimate));
	}

	@Override
	public EstimatesResponse updateEstimates(EstimatesRequest estimates) {
		Estimates estimate = this.estimatesRepository.findById(estimates.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ESTIMATES_NOT_FOUND + estimates.getId()));

		estimate.setBillDate(estimates.getBillDate());
		estimate.setClientId(estimates.getClientId());
		estimate.setDiscount(estimates.getDiscount());
		estimate.setDiscountPercentage(estimates.getDiscountPercentage());
		estimate.setTaxCost(estimates.getTaxCost());
		estimate.setTaxeId(estimates.getTaxeId());
		estimate.setDueDate(estimates.getDueDate());
		estimate.setGrandTotal(estimates.getGrandTotal());
		estimate.setProjectId(estimates.getProjectId());
		estimate.setTotal(estimates.getTotal());
		estimate.setNote(estimates.getNote());
		this.estimatesItemRepository.saveAll(estimates.getEstimateItems());
		Estimates save = this.estimatesRepository.save(estimate);
		return this.estimatesToEstimatesResponse(save);
	}

	@Override
	public EstimatesResponse getEstimatesById(Integer id) {
		Estimates estimate = this.estimatesRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ESTIMATES_NOT_FOUND + id));
		
		return this.estimatesToEstimatesResponse(estimate);
	}

	@Override
	public Page<EstimatesResponse> getAllEstimates(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Estimates> page = this.estimatesRepository.findAllByDeleted(pageRequest,false);
		return page.map(u -> this.estimatesToEstimatesResponse(u));

	}

	@Override
	public Boolean deleteEstimates(Integer id) {
		Estimates estimate = this.estimatesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ESTIMATES_NOT_FOUND + id));
		estimate.setDeleted(true);
		this.estimatesRepository.save(estimate);
		return true;
	}

	@Override
	public Page<EstimatesResponse> searchEstimates(Integer pageNo, Integer pageSize, EstimatesRequest estimates) {
			estimates.setEstimateItems(null);
		estimates.setDiscountPercentage(null);
		estimates.setEid(null);
		estimates.setEstimateItems(null);
		estimates.setId(null);
		estimates.setProjectId(null);
		estimates.setTaxCost(null);
		estimates.setTaxeId(null);
		estimates.setTotal(null);
	
		
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((String) id == "") ? null : id))) // for
		.withMatcher("clientId.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // for
		.withMatcher("projectId.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // for
		.withMatcher("taxeId.id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for
		
		Example<Estimates> example = Example.of(this.ivoicesRequestToInvoices(estimates), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Estimates> page = this.estimatesRepository.findAll(example, pageable);

		return page.map(u -> this.estimatesToEstimatesResponse(u));

	}

}
