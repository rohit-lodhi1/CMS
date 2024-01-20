package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;
public interface IHolidaysService {
	 public Holidays addHolidays(Holidays holidays); 
	   
	   public Holidays getHolidaysById(Integer id);
	   
	   public Holidays updateHolidays(Holidays holidays);
	   
	   public Page<Holidays> getAllHolidays(Integer pageNo,Integer pageSize);
	   
	   public Boolean deleteHolidays(Integer id);

	public	List<Holidays> getHolidaysOfMonth(String month, String year);
	
	   public EmployeeDashboardResponse EmployeeDashboardTodyaHoliday();

		
	  
}
