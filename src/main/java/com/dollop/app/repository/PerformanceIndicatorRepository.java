package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.PerformanceAppraisal;
import com.dollop.app.entity.PerformanceIndicator;

public interface PerformanceIndicatorRepository extends JpaRepository<PerformanceIndicator, Integer> {

public	Page<PerformanceIndicator> findById(PageRequest pageRequest, Integer id);


public Optional<PerformanceIndicator> findByIdAndDeleted(Integer id, boolean b);


}
