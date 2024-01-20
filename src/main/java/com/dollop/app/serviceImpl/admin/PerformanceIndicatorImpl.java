package com.dollop.app.serviceImpl.admin;

import java.sql.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.PerformanceIndicator;
import com.dollop.app.entity.payload.PerformanceIndicatorRequest;
import com.dollop.app.entity.payload.PerformanceIndicatorResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PerformanceIndicatorRepository;
import com.dollop.app.service.admin.PerformanceIndicatorService;

@Service
public class PerformanceIndicatorImpl implements PerformanceIndicatorService {
	@Autowired
	private PerformanceIndicatorRepository performanceIndicatorRepository;
	@Autowired
	private ModelMapper modelMapper;

	public PerformanceIndicatorResponse performanceIndicatortoPerformanceindicatorResponse(
			PerformanceIndicator performance) {
		return this.modelMapper.map(performance, PerformanceIndicatorResponse.class);
	}

	public PerformanceIndicator performanceIndicatorRequesttoperformanceIndicator(
			PerformanceIndicatorRequest performanceIndicator) {
		return this.modelMapper.map(performanceIndicator, PerformanceIndicator.class);
	}

	@Override
	public PerformanceIndicatorResponse createPerformanceIndicator(PerformanceIndicatorRequest performanceIndicator) {
		performanceIndicator.setCreatedAt(new Date(System.currentTimeMillis()));
		
		PerformanceIndicator performanceIndicator1 = this.performanceIndicatorRepository.save(performanceIndicatorRequesttoperformanceIndicator(performanceIndicator));
				return performanceIndicatortoPerformanceindicatorResponse(performanceIndicator1);
	}

	@Override
	public PerformanceIndicatorResponse updatePerformanceIndicator(PerformanceIndicatorRequest performanceIndicator) {
		PerformanceIndicator performanceIndicator2 = this.performanceIndicatorRepository
				.findByIdAndDeleted(performanceIndicator.getId(),false).orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.PERFORMANCE_INDICATOR_NOT_FOUND + performanceIndicator.getId()));
		performanceIndicator2.setAbilityToMeetDeadline(performanceIndicator.getAbilityToMeetDeadline());
		performanceIndicator2.setAdministration(performanceIndicator.getAdministration());
		performanceIndicator2.setAttendance(performanceIndicator.getAttendance());
		performanceIndicator2.setConflictManagement(performanceIndicator.getConflictManagement());
		performanceIndicator2.setCriticalThinking(performanceIndicator.getCriticalThinking());
		performanceIndicator2.setCustomerExperience(performanceIndicator.getCustomerExperience());
		performanceIndicator2.setEfficiency(performanceIndicator.getEfficiency());
		performanceIndicator2.setIntegrity(performanceIndicator.getIntegrity());
		performanceIndicator2.setManagement(performanceIndicator.getManagement());
		performanceIndicator2.setMarketing(performanceIndicator.getMarketing());
		performanceIndicator2.setPresentationSkill(performanceIndicator.getPresentationSkill());
		performanceIndicator2.setProfessionalism(performanceIndicator.getProfessionalism());
		performanceIndicator2.setQualityOfWork(performanceIndicator.getQualityOfWork());
		performanceIndicator2.setTeamWork(performanceIndicator.getTeamWork());
		performanceIndicator2.setDesignation(performanceIndicator.getDesignation());
		performanceIndicator2.setStatus(performanceIndicator.getStatus());
		return performanceIndicatortoPerformanceindicatorResponse(
				this.performanceIndicatorRepository.save(performanceIndicator2));

	}

	@Override
	public void deletePerformanceIndicator(Integer id) {
		PerformanceIndicator pIndicator = this.performanceIndicatorRepository.findByIdAndDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_INDICATOR_NOT_FOUND + id));

		this.performanceIndicatorRepository.deleteById(id);
	}
	
	
	@Override
	public Page<PerformanceIndicatorResponse> getallPerformanceIndicator(Integer PagNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(PagNo, pageSize);
		Page<PerformanceIndicator> page = this.performanceIndicatorRepository.findAll(pageRequest);
		return page.map(t -> this.performanceIndicatortoPerformanceindicatorResponse(t));
	}

	@Override
	public PerformanceIndicatorResponse getaPerformanceIndicatorById(Integer id) {
		PerformanceIndicator performanceIndicator = this.performanceIndicatorRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_INDICATOR_NOT_FOUND + id));
		return this.performanceIndicatortoPerformanceindicatorResponse(performanceIndicator);

	}

	@Override
	public PerformanceIndicatorResponse getPerformanceIndicatorByStatus(Integer id,
			String status) {
		PerformanceIndicator performance = this.performanceIndicatorRepository.findByIdAndDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_INDICATOR_NOT_FOUND + id));
		performance.setStatus(status);
		return this.performanceIndicatortoPerformanceindicatorResponse(this.performanceIndicatorRepository.save(performance));
	}

	@Override
	public Page<PerformanceIndicatorResponse> searchPerformanceIndicator(Integer pageNo, Integer pageSize,
			PerformanceIndicatorRequest performanceIndicator) {
	
	ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
	.withIgnoreCase() // ignoring case of letters
	.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
	.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)))// for
	.withMatcher("department.id", match -> match.transform(value -> value.map(id -> ((Long) id == 0) ? null : id)))// for
	.withMatcher("users.id", match -> match.transform(value -> value.map(id -> ((Long) id == 0) ? null : id)))// for

	.withMatcher("designation.id",
			match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

Example<PerformanceIndicator> example = Example.of(this.performanceIndicatorRequesttoperformanceIndicator(performanceIndicator), matcher);
PageRequest pageable = PageRequest.of(pageNo, pageSize);

Page<PerformanceIndicator> page = this.performanceIndicatorRepository.findAll(example, pageable);

return page.map(u -> this.performanceIndicatortoPerformanceindicatorResponse(u));
}
	}


