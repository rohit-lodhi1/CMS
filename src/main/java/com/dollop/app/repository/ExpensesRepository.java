package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


import com.dollop.app.entity.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses,Integer>{


public	Page<Expenses> findByDeleted(PageRequest pageRequest, boolean b);

public	Optional<Expenses> findByIdAndDeleted(Integer id, boolean b);

	
}
