package com.dollop.app.serviceImpl.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.LeaveApplications;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.LeaveApplicationRequest;
import com.dollop.app.entity.payload.LeaveApplicationResponse;
import com.dollop.app.entity.payload.admin.LeaveStatics;
import com.dollop.app.entity.status.LeaveStatus;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.AttendenceRepository;
import com.dollop.app.repository.LeaveApplicationRepository;
import com.dollop.app.repository.UserRolesRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.ILeaveApplicationService;
import com.dollop.app.service.employee.IAttendenceService;

@Service
public class AdminLeaveApplicationServiceImpl implements ILeaveApplicationService {

	@Autowired
	private LeaveApplicationRepository leaveRepository;

	@Autowired
	private AttendenceRepository attendenceRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserRolesRepository userRolesRepository;

	@Autowired
	private ModelMapper modelMapper;

	public LeaveApplicationResponse leaveApplicationToLeaveApplicationResponse(LeaveApplications leaveApplication) {
		return this.modelMapper.map(leaveApplication, LeaveApplicationResponse.class);
	}

	public LeaveApplications leaveApplicatonRequestToLeaveApplication(LeaveApplicationRequest leaveApplicationRequest) {
		return this.modelMapper.map(leaveApplicationRequest, LeaveApplications.class);
	}

	// create Leave Application
	@Override
	public LeaveApplicationResponse createApplication(LeaveApplicationRequest leaveRequest) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(leaveRequest.getStartDate());
		String endD = formatter.format(leaveRequest.getEndDate());
		leaveRequest.setStatus(LeaveStatus.Pending.toString());
		LocalDate startDate = LocalDate.parse(strDate);
		LocalDate endDate = LocalDate.parse(endD);
		long totalDays = ChronoUnit.DAYS.between(startDate, endDate);
		if (totalDays > 0)
			leaveRequest.setTotalDays((double) totalDays);

		LeaveApplications leave = this.leaveRepository
				.save(this.leaveApplicatonRequestToLeaveApplication(leaveRequest));
		return this.leaveApplicationToLeaveApplicationResponse(leave);
	}

	// update Leave Application
	@Override
	public LeaveApplicationResponse updateLeaveApplication(LeaveApplicationRequest leaveRequest) {
		LeaveApplications leave = this.leaveRepository.findById(leaveRequest.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.LEAVE_APPLICATION_NOT_FOUND + leaveRequest.getId()));
		leave.setCheckedBy(leaveRequest.getCheckedBy());
		leave.setCreatedBy(leaveRequest.getCreatedBy());
		leave.setStartDate(leaveRequest.getStartDate());
		leave.setEndDate(leaveRequest.getEndDate());
		leave.setReason(leaveRequest.getReason());
		leave.setLeaveTypeId(leaveRequest.getLeaveTypeId());
		leave.setTotalHours(leaveRequest.getTotalHours());
		leave.setTotalDays(leaveRequest.getTotalDays());
		leave.setStatus(leaveRequest.getStatus());
		leave = this.leaveRepository.save(leave);
		return this.leaveApplicationToLeaveApplicationResponse(leave);

	}

	// get All Leave Applications
	@Override
	public Page<LeaveApplicationResponse> getAllLeaveApplication(Integer pageNo, Integer pageSize) {

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(Direction.DESC, "id"));
		Page<LeaveApplications> page = this.leaveRepository.findAll(pageRequest);
//		getLeaveStatics();
		return page.map(l -> this.leaveApplicationToLeaveApplicationResponse(l));
	}

	// get leave Application by status
	@Override
	public Page<LeaveApplicationResponse> getLeaveApplicationByStatus(Integer pageNo, Integer pageSize, String status) {

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<LeaveApplications> page = this.leaveRepository.findByStatus(pageRequest, status);

		return page.map(l -> this.leaveApplicationToLeaveApplicationResponse(l));
	}

	// delete Leave Application by id
	@Override
	public Boolean deleteLeaveApplication(Integer id) {
		LeaveApplications leave = this.leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_APPLICATION_NOT_FOUND + id));

		this.leaveRepository.delete(leave);
		return true;
	}

	// update Leave Application status by id
	@Override
	public LeaveApplicationResponse updateLeaveApplicationStatus(String status, Integer id, String email) {
		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));

		LeaveApplications leave = this.leaveRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.LEAVE_APPLICATION_NOT_FOUND + id));
		leave.setStatus(status);
		leave.setCheckedBy(user);
		return this.leaveApplicationToLeaveApplicationResponse(this.leaveRepository.save(leave));

	}

	// get leave statics
	@Override
	public LeaveStatics getLeaveStatics() {

		Integer present = this.attendenceRepository.getCountOfEmployeePresentByDate(LocalDate.now()).orElse(0);
		Integer totalEmployee = this.userRolesRepository.getCountOfUsersByRole(AppConstants.EMPLOYEE_ROLE_ID).orElse(0);
		Integer pendingLeaves = this.leaveRepository.getCountOFLeaveByStatus(LeaveStatus.Pending.toString()).orElse(0);
		Integer plannedLeaves = this.leaveRepository
				.countPlannedLeavesByDate(LocalDate.now(), LeaveStatus.Approved.toString()).orElse(0);
		LeaveStatics statics = new LeaveStatics(present, totalEmployee, plannedLeaves, totalEmployee - present,
				pendingLeaves);
		return statics;
	}

	// filter searching
	@Override
	public Page<LeaveApplicationResponse> searchLeaveApplication(Integer pageNo, Integer pageSize,
			LeaveApplicationRequest leaveRequest) {

		Users user = leaveRequest.getApplicantId();
		user.setDesignation(null);

		user.setIsAdmin(null);
		user.setIsPrime(null);
		user.setEnableWebNotification(null);
		user.setEnableEmailNotification(null);
		user.setDisableLogin(null);

		leaveRequest.getLeaveTypeId().setDeleted(null);
		leaveRequest.setTotalHours(null);
		leaveRequest.setTotalDays(null);
		leaveRequest.setCheckedBy(null);

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // variable
				.withMatcher("leaveTypeId.id",
						match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)))
				.withMatcher("applicantId.id",
						match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))) // variable
				.withMatcher("totalHours",
						match -> match.transform(value -> value.map(id -> ((double) id == (double) 0) ? null : id)))
				.withMatcher("totalDays",
						match -> match.transform(value -> value.map(id -> ((double) id == (double) 0) ? null : id)));

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Example<LeaveApplications> example = Example.of(this.leaveApplicatonRequestToLeaveApplication(leaveRequest),
				matcher);

		Page<LeaveApplications> page = this.leaveRepository.findAll(example, pageRequest);

		return page.map(l -> this.leaveApplicationToLeaveApplicationResponse(l));
	}

}
