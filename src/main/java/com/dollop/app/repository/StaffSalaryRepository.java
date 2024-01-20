package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.StaffSalary;
import com.dollop.app.entity.Trainers;

public interface StaffSalaryRepository extends JpaRepository<StaffSalary, Integer> {
	public Optional<StaffSalary> findByIdAndIsDeleted(Integer id, boolean b);

	public Page<StaffSalary> findByIsDeleted(PageRequest page, boolean b);

}
