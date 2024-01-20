package com.dollop.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.GoalType;
import com.dollop.app.entity.Holidays;

public interface HolidaysRepository extends JpaRepository<Holidays,Integer>{

	public Optional<Holidays> findByIdAndDeleted(Integer id, boolean b);
	
	@Query(value="Select * from holidays h where h.holiday_date like %:date%",nativeQuery = true)
	public List<Holidays> getHolidaysOfMonth(String date);
	
	


	@Query(value = " select *  from holidays h where date(h.holiday_date) > date(:now) ORDER BY h.holiday_date ASC limit 3 ",nativeQuery = true)
	public List<Holidays> fetchEmployeeDashboardDetailsHoliday(LocalDate now);

	
	
	

}
