package com.dollop.app.serviceImpl.employee;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.LeaveApplications;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.Leaves;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.employee.EmployeeLeaveStatics;
import com.dollop.app.entity.status.LeaveType;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.LeaveApplicationRepository;
import com.dollop.app.repository.LeaveTypeRepository;
import com.dollop.app.repository.LeavesRepository;
import com.dollop.app.repository.UserRegistrationRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.employee.ILeaveApplicationService;
import com.dollop.app.utils.PageResponse;

@Service
public class EmployeeLeaveApplicationServiceImpl implements ILeaveApplicationService{

	@Autowired 
	private LeaveApplicationRepository leaveApplicationRepository;
	
	@Autowired 
	private LeavesRepository leavesRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	

	@Autowired
	private ModelMapper modelMapper;

	
	public  LeaveApplicationResponse leaveApplicationToLeaveApplicationResponse(LeaveApplications leaveApplication) {
		return this.modelMapper.map(leaveApplication, LeaveApplicationResponse.class);
	}

	public  LeaveApplications leaveApplicatonRequestToLeaveApplication(LeaveApplicationRequest leaveApplicationRequest) {
		return this.modelMapper.map(leaveApplicationRequest, LeaveApplications.class);
	}
	
	
	// create Leave Application
		@Override
		public LeaveApplicationResponse createApplication(LeaveApplicationRequest leaveRequest,String email) {
			
			Users user = this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND+email));
			leaveRequest.setApplicantId(user);
			if(Objects.isNull(leaveRequest.getEndDate()))
				leaveRequest.setEndDate(leaveRequest.getStartDate());
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    String strDate= formatter.format(leaveRequest.getStartDate());  
			    String endD= formatter.format(leaveRequest.getEndDate());
			    
			LocalDate startDate = LocalDate.parse(strDate);
			LocalDate endDate = LocalDate.parse(endD);
			long totalDays = ChronoUnit.DAYS.between(startDate, endDate)+1;
			leaveRequest.setTotalDays((double)(totalDays==0?1:totalDays));
			
			 LeaveApplications leave = this.leaveApplicationRepository.save(this.leaveApplicatonRequestToLeaveApplication(leaveRequest));
			 return this.leaveApplicationToLeaveApplicationResponse(leave);
		}
		
	    // update Leave Application 
		@Override
		public LeaveApplicationResponse updateLeaveApplication(LeaveApplicationRequest leaveRequest) {
			LeaveApplications leave = this.leaveApplicationRepository.findById(leaveRequest.getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							AppConstants.LEAVE_APPLICATION_NOT_FOUND+leaveRequest.getId()));
			leave.setCheckedBy(leaveRequest.getCheckedBy());
			leave.setCreatedBy(leaveRequest.getCreatedBy());
			leave.setStartDate(leaveRequest.getStartDate());
			leave.setEndDate(leaveRequest.getEndDate());
			leave.setReason(leaveRequest.getReason());
			leave.setLeaveTypeId(leaveRequest.getLeaveTypeId());
			leave.setTotalHours(leaveRequest.getTotalHours());
			
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    String strDate= formatter.format(leaveRequest.getStartDate());  
			    String endD= formatter.format(leaveRequest.getEndDate());
			    
			LocalDate startDate = LocalDate.parse(strDate);
			LocalDate endDate = LocalDate.parse(endD);
			
			long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
			
			leave.setTotalDays((double)totalDays);
			leave.setStatus(leaveRequest.getStatus());
		    leave  = this.leaveApplicationRepository.save(leave);
			return this.leaveApplicationToLeaveApplicationResponse(leave); 
		}


	// get Leave Application by id
	@Override
	public LeaveApplicationResponse getLeaveApplicationById(Integer id) {
		 LeaveApplications leave = this.leaveApplicationRepository.findByIdAndDeleted(id,false).orElseThrow(()->new ResourceNotFoundException(AppConstants.LEAVE_APPLICATION_NOT_FOUND+id));
		return this.leaveApplicationToLeaveApplicationResponse(leave);
	}

	// get All Leave Application of Applicant by id
	@Override
	public Page<LeaveApplicationResponse> getLeaveApplicationByApplicantId(Integer pageNo,Integer pageSize,String email) {
	   Users user = this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND+email));
     	PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<LeaveApplications> page = this.leaveApplicationRepository.findByApplicantId(pageRequest,user);
		System.out.println(getLeaveStatics(email));
	     return page.map( l -> this.leaveApplicationToLeaveApplicationResponse(l));
	}

	// get Leave Application by Type id
	@Override
	public Page<LeaveApplicationResponse> getLeaveApplicationByTypeId(Integer pageNo,Integer pageSize,Integer id) {
	   LeaveTypes type = new LeaveTypes();
       type.setId(id);
       PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
       Page<LeaveApplications> page = this.leaveApplicationRepository.findByLeaveTypeId(pageRequest, type);
	   return page.map( l -> this.leaveApplicationToLeaveApplicationResponse(l));
	  
	}
	
	// get leave statics
	@Override
	public EmployeeLeaveStatics getLeaveStatics(String email) {
		  Users user = this.userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND+email));
	      	   Optional<LeaveTypes> leaveType = this.leaveTypeRepository.findByTitleContaining(LeaveType.Medical.toString());
	      	   EmployeeLeaveStatics statics = new EmployeeLeaveStatics();
	      	   statics.setAnnualLeaves(AppConstants.ANNUAL_EMPLOYEE_LEAVES);
	      	   int year = LocalDate.now().getYear();
	      	 if(leaveType.isPresent()) {
	      		 List<LeaveApplications> medicalLeaves = this.leaveApplicationRepository.getLeavesByLeaveTypeAndUserId(LocalDate.now(),leaveType.get().getId(),user.getId());
	      		    List<Leaves> total = this.leavesRepository.getLeavesByUserId(user.getId(), LocalDate.now());
	      		    int medical=0;
	      			 statics.setMedicalLeaves(medical);medicalLeaves.stream().forEach(l->{
	total.stream().forEach(t ->{
		  if(t.getDate().equals(l.getStartDate()) || t.getDate().equals(l.getEndDate()) ||t.getDate().isAfter(convertToLocalDateViaSqlDate(l.getStartDate())) && t.getDate().isBefore(convertToLocalDateViaSqlDate(l.getEndDate()))) {
			   statics.setMedicalLeaves(statics.getMedicalLeaves()+1);
	      }
	 	
      });
});
	      		  
	      		 statics.setOtherLeaves(total.size()-statics.getMedicalLeaves());
	      		 statics.setRemainingLeaves(AppConstants.ANNUAL_EMPLOYEE_LEAVES-total.size());
	      		  return statics;
	      	 }
	      	   return statics;
	}

	// delete Leave Application by id
	@Override
	public Boolean deleteLeaveApplication(Integer id) {
		LeaveApplications leave = this.leaveApplicationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(AppConstants.LEAVE_APPLICATION_NOT_FOUND+id));
		
		this.leaveApplicationRepository.delete(leave);
		return true;
	}
	
	public LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
	    return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
	}
}
