package com.dollop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.EstimateItems;

public interface EstimateItemRepository extends JpaRepository<EstimateItems, Integer> {

}
