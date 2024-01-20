package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.PerformanceAppraisal;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.PerformanceAppraisalRequest;
import com.dollop.app.entity.payload.PerformanceAppraisalResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserAlreadyPresentException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.PerformanceAppraisalRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IPerformanceAppraisalService;
import com.dollop.app.service.admin.PerformanceIndicatorService;

@Service
public class PerformanceAppraisalServiceImpl implements IPerformanceAppraisalService {

	@Autowired
	private PerformanceAppraisalRepository performanceAppraisalRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsersRepository usersRepository;

	public PerformanceAppraisalResponse PerformanceAppraisalToPerformanceAppraisalResponse(
			PerformanceAppraisal performanceAppraisal) {

		return this.modelMapper.map(performanceAppraisal, PerformanceAppraisalResponse.class);
	}

	private PerformanceAppraisal performanceAppraisalRequestToPerformanceAppraisal(
			PerformanceAppraisalRequest performanceAppraisalRequest)

	{
		return this.modelMapper.map(performanceAppraisalRequest, PerformanceAppraisal.class);
	}

	@Override
	public PerformanceAppraisalResponse createPerformanceAppraisal(
			PerformanceAppraisalRequest performanceAppraisalRequest) {
		Users u = this.usersRepository.findByIdAndDeleted(performanceAppraisalRequest.getUser().getId(), false).orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + performanceAppraisalRequest.getUser().getId()));
		if (u != null) {
			
			if (this.performanceAppraisalRepository.existsByUser(u)) {
				throw new UserAlreadyPresentException("Performance Appraisal Already Present");
			}
			PerformanceAppraisal performanceAppraisal = this.performanceAppraisalRepository
					.save(performanceAppraisalRequestToPerformanceAppraisal(performanceAppraisalRequest));
         
			return this.PerformanceAppraisalToPerformanceAppraisalResponse(performanceAppraisal);
		}
		throw new UserNotFoundException("Performance Appraisal Already Present");
	}

	@Override
	public PerformanceAppraisalResponse updatePerformanceAppraisal(
			PerformanceAppraisalRequest performanceAppraisalRequest) {
		PerformanceAppraisal performanceAppraisal = this.performanceAppraisalRepository
				.findByIdAndIsDelete(performanceAppraisalRequest.getId(), false)
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.PERFORMANCE_APPRAISAL_NOT_FOUND + performanceAppraisalRequest.getId()));
		performanceAppraisal.setAbilityToMeetDeadline(performanceAppraisalRequest.getAbilityToMeetDeadline());
		performanceAppraisal.setAdministration(performanceAppraisalRequest.getAdministration());
		performanceAppraisal.setAttendance(performanceAppraisalRequest.getAttendance());
		performanceAppraisal.setConflictManagement(performanceAppraisalRequest.getConflictManagement());
		performanceAppraisal.setCriticalThinking(performanceAppraisalRequest.getCriticalThinking());
		performanceAppraisal.setCustomerExperience(performanceAppraisalRequest.getCustomerExperience());
		performanceAppraisal.setCreatedAt(performanceAppraisalRequest.getCreatedAt());
		performanceAppraisal.setEfficiency(performanceAppraisalRequest.getEfficiency());
		performanceAppraisal.setIntegrity(performanceAppraisalRequest.getIntegrity());
		performanceAppraisal.setManagement(performanceAppraisalRequest.getManagement());
		performanceAppraisal.setMarketing(performanceAppraisalRequest.getMarketing());
		performanceAppraisal.setPresentationSkill(performanceAppraisalRequest.getPresentationSkill());
		performanceAppraisal.setProfessionalism(performanceAppraisalRequest.getProfessionalism());
		performanceAppraisal.setQualityOfWork(performanceAppraisalRequest.getQualityOfWork());
		performanceAppraisal.setStatus(performanceAppraisalRequest.getStatus());
		performanceAppraisal.setTeamWork(performanceAppraisalRequest.getTeamWork());
		performanceAppraisal.setUser(performanceAppraisalRequest.getUser());
		return this.PerformanceAppraisalToPerformanceAppraisalResponse(
				this.performanceAppraisalRepository.save(performanceAppraisal));
	}

	@Override
	public PerformanceAppraisalResponse getPerformanceAppraisalById(Integer id) {
		PerformanceAppraisal performanceAppraisal = this.performanceAppraisalRepository.findByIdAndIsDelete(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_APPRAISAL_NOT_FOUND + id));
		return PerformanceAppraisalToPerformanceAppraisalResponse(performanceAppraisal);

	}

	@Override
	public Page<PerformanceAppraisalResponse> getAllPerformanceApraisal(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<PerformanceAppraisal> perPage = this.performanceAppraisalRepository.findAllByIsDelete(pageRequest,false);
		return perPage.map(t -> this.PerformanceAppraisalToPerformanceAppraisalResponse(t));
	}

	@Override
	public Boolean deletePerformanceApprisal(Integer id) {
		PerformanceAppraisal performanceAppraisal = this.performanceAppraisalRepository.findByIdAndIsDelete(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_APPRAISAL_NOT_FOUND + id));
		performanceAppraisal.setIsDelete(true);
		this.performanceAppraisalRepository.save(performanceAppraisal);
		return true;
	}

	@Override
	public PerformanceAppraisalResponse getPerformanceAppraisalByStatus(Integer id, String status) {
	
		PerformanceAppraisal performanceAppraisal = this.performanceAppraisalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.PERFORMANCE_APPRAISAL_NOT_FOUND + id));
		performanceAppraisal.setStatus(status);
		return this.PerformanceAppraisalToPerformanceAppraisalResponse(this.performanceAppraisalRepository.save(performanceAppraisal));
	}
	
	

}
