package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.GoalType;

public interface GoalListRepository extends JpaRepository<GoalList,Integer>{
	
	public Page<GoalList> findByIsDelete(PageRequest page,Boolean deleted);

	public Optional<Department> findByIdAndIsDelete(Integer id, boolean b);

	@Query(value="UPDATE goal_list"
			+ "SET progress ="
			+ "    CASE"
			+ "        WHEN CURDATE() < start_date THEN 0.00"
			+ "        WHEN CURDATE() > end_date THEN 100.00"
			+ "        ELSE ROUND(DATEDIFF(CURDATE(), start_date) / DATEDIFF(end_date, start_date) * 100, 2)"
			+ "    END"
			+ "WHERE end_date >= CURDATE();",nativeQuery = true)
	public void updateProgressOfGoalList();
	
}
