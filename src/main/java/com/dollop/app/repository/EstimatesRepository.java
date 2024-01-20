package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Estimates;
import com.dollop.app.entity.Invoices;

public interface EstimatesRepository extends JpaRepository<Estimates,Integer>{
	public Page<Estimates> findByDeleted(PageRequest page,Boolean deleted);

	public Optional<Estimates> findByIdAndDeleted(Integer id, boolean b);

	public Page<Estimates> findAllByDeleted(PageRequest pageRequest, boolean b);
	
}
