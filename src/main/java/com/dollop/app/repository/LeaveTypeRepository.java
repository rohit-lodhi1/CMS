package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.LeaveApplications;
import com.dollop.app.entity.LeaveTypes;

public interface LeaveTypeRepository extends JpaRepository<LeaveTypes, Integer>{

	public Optional<LeaveTypes> findByIdAndDeleted(Integer id, boolean b);

	public List<LeaveTypes> findAllByDeleted(boolean b);
	
	List<LeaveTypes>  findAllByStatus(String status);
	
	public Optional<LeaveTypes> findByTitleContaining(String title);
}
