package com.dollop.app.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Invoices;
import com.dollop.app.entity.LeaveApplications;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.Users;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplications, Integer>{

	public Page<LeaveApplications>  findByApplicantId(PageRequest pageRequest,Users applicantId);
	
	public Page<LeaveApplications>  findByLeaveTypeId(PageRequest pageRequest,LeaveTypes leaveTypeId);
	
	public Page<LeaveApplications>   findByStatus(PageRequest pageRequest,String status);
	
	public Optional<LeaveApplications> findByIdAndDeleted(Integer id, boolean b);

	@Query("SELECT COUNT(*) FROM  LeaveApplications l WHERE l.status=:status ")
	public Optional<Integer> getCountOFLeaveByStatus(String status);
	
	@Query("SELECT COUNT(*) FROM LeaveApplications l WHERE :date BETWEEN l.startDate AND l.endDate AND l.status =:status")
	public Optional<Integer> countPlannedLeavesByDate(LocalDate date,String status);
	
	@Query("SELECT COUNT(*) FROM LeaveApplications l WHERE l.leaveTypeId.id =:id AND l.applicantId.id=:userId AND l.startDate Like %:year%")
	public Optional<Integer> countLeavesByLeaveType( Integer year,Integer id,Integer userId); 
	
	@Query("SELECT COUNT(*) FROM LeaveApplications l where l.applicantId.id=:id AND l.startDate Like %:year%")
	public Optional<Integer> countLeavesByApplicantId(Integer year,Integer id);
	
	
	@Query("SELECT l FROM LeaveApplications l WHERE l.leaveTypeId.id =:id AND l.applicantId.id=:userId AND Year(l.startDate) = Year(:year)")
	public List<LeaveApplications> getLeavesByLeaveTypeAndUserId( LocalDate year,Integer id,Integer userId); 
	

}
