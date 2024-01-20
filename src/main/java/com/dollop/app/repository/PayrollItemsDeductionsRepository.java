package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.PayrollItemsAdditions;
import com.dollop.app.entity.PayrollItemsDeductions;

public interface PayrollItemsDeductionsRepository extends JpaRepository<PayrollItemsDeductions, Integer> {

	public Optional<PayrollItemsDeductions> findByIdAndIsDelete(Integer id, boolean b);

	public Page<PayrollItemsDeductions> findByIsDelete(PageRequest page, boolean b);

	
}
