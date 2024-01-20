package com.dollop.app.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dollop.app.entity.OverTime;

public interface OverTimeRepository extends JpaRepository<OverTime, Integer> {

	Page<OverTime> findByIsDeleted(PageRequest pageRequest, boolean b);

	OverTime findByIdAndIsDeleted(Integer id, boolean b);

	@Query("SELECT SUM(ot.overTimeHours) AS totalHours, COUNT(DISTINCT ot.userId.id) AS employeeCount ,"+
			"SUM(CASE WHEN ot.status = 'Pending' THEN 1 ELSE 0 END) AS pending , "
			+ "SUM(CASE WHEN ot.status = 'Rejected' THEN 1 ELSE 0 END) AS rejectedCount "
		
			+ " FROM OverTime ot " +
			"WHERE ot.isDeleted=false And ot.overTimeDate BETWEEN :startDate AND :endDate  ")
	Object findTotalWorkedHoursBetweenDates(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);
}
