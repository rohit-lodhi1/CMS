package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	public Page<Promotion> findByIsDeleted(PageRequest pageRequest, Boolean isDelete);

	public Optional<Promotion> findByIdAndIsDeleted(Integer id, boolean b);


}
