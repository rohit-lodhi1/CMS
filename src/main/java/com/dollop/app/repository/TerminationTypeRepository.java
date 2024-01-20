package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.Termination;
import com.dollop.app.entity.TerminationType;

public interface TerminationTypeRepository extends JpaRepository<TerminationType,Integer>{

	public Page<TerminationType> findByIsDelete(PageRequest page,Boolean deleted);

	public Optional<TerminationType> findByIdAndIsDelete(Integer id, boolean b);

}
