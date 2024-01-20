package com.dollop.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Resignation;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Users;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

	public Page<Tasks> findAllByOrderByIdDesc(Pageable page);

	public Optional<Tasks> findByIdAndDeleted(Long id, boolean b);

	public Page<Tasks> findByProjectIdAndDeleted(PageRequest pageRequest, Projects project, boolean b);

	public Page<Tasks> findByProjectIdAndDeletedAndStatus(PageRequest pageRequest, Projects project, boolean b,
			String status);

	@Query("select count(*) AS totalTasks ,"
			+ "sum(CASE WHEN FUNCTION('DATE',t.deadline) < FUNCTION('Date',:currentDate) AND t.status !='Completed' THEN 1 ELSE 0 END) AS OVERDUE,  "
			+ "sum(CASE WHEN t.status ='Completed' Then 1 ELSE 0 END  )AS Completed"
			+ ",sum(CASE WHEN t.status ='Inprogress' Then 1 ELSE 0 END  )AS Inprogress"
			+ ",sum(CASE WHEN t.status ='OnHold' Then 1 ELSE 0 END  )AS OnHold"
			+ ",sum(CASE WHEN t.status ='Pending' Then 1 ELSE 0 END  )AS Pending"
			+ ",sum(CASE WHEN t.status ='Review' Then 1 ELSE 0 END  )AS Review" + " FROM Tasks t")
	public Object findByStatusDetailsOfTasks(@Param("currentDate") LocalDate currentDate);

	public List<Tasks> findByDeletedAndAssignedToOrCollaborators(boolean b, Users user, Users user2);


	
//	public Page<Tasks> findByProjectIdAndDeletedAndAssignedToOrCollaborators(Projects project, boolean b, Users users,
//			Users users2, PageRequest pageRequest);

	public Page<Tasks> findByProjectIdAndDeletedAndAssignedToOrCollaboratorsAndProjectIdAndDeleted(Projects project,
			boolean b, Users users, Users users2, Projects project2, boolean c, PageRequest pageRequest);

	
}
