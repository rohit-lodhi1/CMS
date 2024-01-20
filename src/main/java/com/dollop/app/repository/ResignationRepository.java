package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.Promotion;
import com.dollop.app.entity.Resignation;

public interface ResignationRepository extends JpaRepository<Resignation, Integer> {

	public Page<Resignation> findByIsDelete(PageRequest pageRequest, boolean b);

	public Optional<Resignation> findByIdAndIsDelete(Integer id, boolean b);

}
