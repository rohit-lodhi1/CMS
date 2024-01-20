package com.dollop.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Leaves;

public interface LeavesRepository extends JpaRepository<Leaves, Long>{
 
	@Query("SELECT COUNT(*) FROM Leaves l where l.employee.id= :id AND YEAR(l.date) = YEAR(:date)")
	public Integer getCountLeavesByUserId(Integer id,LocalDate date);
	
	@Query("SELECT l FROM Leaves l where l.employee.id= :id AND YEAR(l.date) = YEAR(:date)")
	public List<Leaves> getLeavesByUserId(Integer id,LocalDate date);
	
}
