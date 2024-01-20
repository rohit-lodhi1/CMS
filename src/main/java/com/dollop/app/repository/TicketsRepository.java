package com.dollop.app.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.TerminationType;
import com.dollop.app.entity.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets,Integer>{

	public Page<Tickets> findByDeleted(PageRequest page,Boolean deleted);
	
	public Optional<Tickets> findByIdAndDeleted(Integer id, boolean b);
	
	@Query(value="SELECT COUNT(*) AS totaltickets,\r\n"
			+ "SUM(CASE WHEN status IN ('Open', 'Reopened') THEN 1 ELSE 0 END) AS newTickets ,\r\n"
			+ "			SUM(CASE WHEN status = 'Closed' THEN 1 ELSE 0 END) AS solvedTickets,\r\n"
			+ "            SUM(CASE WHEN status IN ('InProgress', 'OnHold') THEN 1 ELSE 0 END) AS pendingTickets,\r\n"
			+ "           SUM(CASE WHEN status = 'Cancelled' THEN 1 ELSE 0 END) AS cancelledTickets\r\n"
			+ "			 FROM tickets WHERE deleted=false ",nativeQuery = true)
	public Object getAllStaticsOfTickets();

}
