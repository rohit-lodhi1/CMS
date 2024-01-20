package com.dollop.app.serviceImpl.employee;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.HolidaysRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.employee.IEmployeeDashboardService;
import com.dollop.app.service.employee.IUsersService;
@Service
public class EmployeeDashboardServiceImpl implements IEmployeeDashboardService {
	

	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private HolidaysRepository holidaysRepository;
	// fetching details of Employee details
	
	@Override
	public EmployeeDashboardResponse fetchDetails(String email,String status) {
		
		Users user = this.usersRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		
		List<Object[]> details = this.usersRepository.fetchEmployeeDashboardDetails(user.getId(),status);
		  List<Holidays> upCommingHolidays = this.holidaysRepository.fetchEmployeeDashboardDetailsHoliday(LocalDate.now());
		EmployeeDashboardResponse response = new EmployeeDashboardResponse();
		details.forEach(object->{
			
			response.setTotalTasks((Long)details.get(1)[0]);
			response.setTotalPendingTask((Long)details.get(2)[0]);
			response.setTotalProjects((Long)details.get(0)[0]);
			response.setUpCommingHolidays(upCommingHolidays);
									
		});
return response;
	}


	


}
		


