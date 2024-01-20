package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.PayrollItemsAdditions;
import com.dollop.app.entity.Trainers;

public interface PayrollItemsAdditionsRepository extends JpaRepository<PayrollItemsAdditions, Integer>{
	public Optional<PayrollItemsAdditions> findByIdAndIsDelete(Integer id, boolean b);

	public Page<PayrollItemsAdditions> findByIsDelete(PageRequest page, boolean b);

}
