package com.dollop.app.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.TimeSheets;

public interface TimeSheetRepository extends JpaRepository<TimeSheets, Integer> {

//	
// public TimeSheets findByTotalTimeBetween(Timestamp startTime,Timestamp endTime);

//	public Page<TimeSheets> findAllByClientId(Pageable page, Clients client);

	public Page<TimeSheets> findByProjectId(Pageable page, Projects project);

	public Page<TimeSheets> findByTaskId(Pageable page, Tasks task);

	public Optional<TimeSheets> findByIdAndDeleted(Integer id, boolean b);

}
