package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.PayrollItemsOvertime;

public interface PayrollItemsOvertimeRepository extends JpaRepository<PayrollItemsOvertime,Integer>{

	public Optional<PayrollItemsOvertime> findByIdAndIsDelete(Integer id, boolean b);

	public Page<PayrollItemsOvertime> findByIsDelete(PageRequest page, boolean b);

	
}
