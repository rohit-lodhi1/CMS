package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.StaffSalary;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.StaffSalaryRequest;
import com.dollop.app.entity.payload.StaffSalaryResponse;
import com.dollop.app.entity.payload.TrainerRequest;
import com.dollop.app.entity.payload.TrainerResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.StaffSalaryRepository;
import com.dollop.app.repository.TrainersRepository;
import com.dollop.app.service.admin.IStaffSalaryService;
@Service
public class StaffSalaryServiceImpl implements IStaffSalaryService {
	@Autowired
	private StaffSalaryRepository staffSalaryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public StaffSalaryResponse staffSalaryToStaffSalaryResponse(StaffSalary staffSalary) {
		return this.modelMapper.map(staffSalary, StaffSalaryResponse.class);
	}

	public StaffSalary staffSalaryResquestToStaffSalary(StaffSalaryRequest staffSalaryRequest) {
		return this.modelMapper.map(staffSalaryRequest, StaffSalary.class);
	}


	@Override
	public StaffSalaryResponse addStaffSalary(StaffSalaryRequest staffSalary) {
		StaffSalary staffSalar = this.staffSalaryRepository.save(this.staffSalaryResquestToStaffSalary(staffSalary));
		return this.staffSalaryToStaffSalaryResponse(staffSalar);

	}

	@Override
	public StaffSalaryResponse getStaffSalaryById(Integer id) {
		StaffSalary staffSalar = this.staffSalaryRepository.findByIdAndIsDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.STAFFSALARY_NOT_FOUND + id));

		return this.staffSalaryToStaffSalaryResponse(staffSalar);
	
	}

	@Override
	public StaffSalaryResponse updateStaffSalary(StaffSalaryRequest trainers) {
		StaffSalary staffSalar = this.staffSalaryRepository.findByIdAndIsDeleted(trainers.getId(),false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.STAFFSALARY_NOT_FOUND + trainers.getId()));
	
		staffSalar.setAllowance(trainers.getAllowance());
		staffSalar.setBasicStaffSalary(trainers.getBasicStaffSalary());
		staffSalar.setConveyance(trainers.getConveyance());
		staffSalar.setDa(trainers.getDa());
		staffSalar.setEsi(trainers.getEsi());
		staffSalar.setHra(trainers.getHra());
		staffSalar.setLabourWelfare(trainers.getLabourWelfare());
		staffSalar.setMedicalAllowance(trainers.getMedicalAllowance());
		staffSalar.setNetSalary(trainers.getNetSalary());
		staffSalar.setOthers(trainers.getOthers());
		staffSalar.setOthers1(trainers.getOthers1());
		staffSalar.setPf(trainers.getPf());
		staffSalar.setProfTax(trainers.getProfTax());
		staffSalar.setStaff(trainers.getStaff());
		staffSalar.setStaffLeave(trainers.getStaffLeave());
		staffSalar.setTds(trainers.getTds());
		
		
		return this.staffSalaryToStaffSalaryResponse(this.staffSalaryRepository.save(staffSalar));
	}

	@Override
	public Page<StaffSalaryResponse> getAllStaffSalary(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<StaffSalary> trainers = this.staffSalaryRepository.findByIsDeleted(page,false);

		return trainers.map( t -> this.staffSalaryToStaffSalaryResponse(t));
	}

	@Override
	public Boolean deleteStaffSalary(Integer id) {
		StaffSalary staffSalary = this.staffSalaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.STAFFSALARY_NOT_FOUND + id));

		staffSalary.setIsDeleted(true);
		this.staffSalaryRepository.save(staffSalary);
		return true;
}

	@Override
	public Page<StaffSalaryResponse> searchStaffSalary(Integer pageNo, Integer pageSize,
			StaffSalaryRequest StaffSalaryRequest) {
		
		
		
		StaffSalaryRequest.getStaff().setDesignation(null);
		StaffSalaryRequest.getStaff().setId(null);
		//StaffSalaryRequest.setStaff(null);
		

		
StaffSalaryRequest.getStaff().setIsAdmin(null);
StaffSalaryRequest.getStaff().setIsPrime(null);
StaffSalaryRequest.getStaff().setEnableWebNotification(null);
StaffSalaryRequest.getStaff().setEnableEmailNotification(null);
StaffSalaryRequest.getStaff().setDisableLogin(null);
	
	
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
					.withIgnoreCase() // ignoring case of letters
					.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
					.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)));// for
		
			
			Example<StaffSalary> example = Example.of(this.staffSalaryResquestToStaffSalary(StaffSalaryRequest), matcher);
			PageRequest pageable = PageRequest.of(pageNo, pageSize);

			Page<StaffSalary> page = this.staffSalaryRepository.findAll(example, pageable);

			return page.map(u -> this.staffSalaryToStaffSalaryResponse(u));
		}
	}


