package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.GoalType;

public interface GoalTypeRepository extends JpaRepository<GoalType, Integer> {
	public Page<GoalType> findByIsDelete(PageRequest page, Boolean deleted);

	public List<GoalType> findByIsDelete(Boolean deleted);

	public Optional<GoalType> findByIdAndIsDelete(Integer id, boolean b);

}
