package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Taxes;
import com.dollop.app.entity.Trainers;

public interface TaxesRepository extends JpaRepository<Taxes, Integer>{
	
public Page<Taxes> findByDeleted(PageRequest page,Boolean deleted);
	
	public	Optional<Taxes> findByIdAndDeleted(Integer id, boolean b);
	
	public Page<Taxes> findByStatus(PageRequest pageRequest, String status);

	public Page<Taxes> findAllByDeleted(PageRequest page, boolean b);
	

}
