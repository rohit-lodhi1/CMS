 package com.dollop.app.serviceImpl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.payload.employee.EmployeeDashboardResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.HolidaysRepository;
import com.dollop.app.service.IHolidaysService;

@Service
public class HolidaysServiceImpl implements IHolidaysService{
	@Autowired
	private HolidaysRepository holidaysRepository;

	@Override
	public Holidays addHolidays(Holidays holidays) {

		LocalDate localDate = holidays.getHolidayDate().toLocalDate();
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
	holidays.setDay(dayOfWeek.toString());
		return this.holidaysRepository.save(holidays);
	}

	@Override
	public Holidays getHolidaysById(Integer id) {
		Holidays holidays = this.holidaysRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.HOLIDAYS_NOT_FOUND + id));

		return holidays;
	}

	@Override
	public Holidays updateHolidays(Holidays holidays) {
		Holidays holiday = this.holidaysRepository.findById(holidays.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.HOLIDAYS_NOT_FOUND + holidays.getId()));
		holiday.setDay(holidays.getDay());
		holiday.setDeleted(holidays.getDeleted());
		holiday.setHolidayDate(holidays.getHolidayDate());
		holiday.setId(holidays.getId());
		holiday.setTitle(holidays.getTitle());

		return this.holidaysRepository.save(holiday);
	}

	@Override
	public List<Holidays> getHolidaysOfMonth(String month,String year){
		int m =LocalDate.now().getMonthValue();
		int y =LocalDate.now().getYear();
		if(Objects.nonNull(month) && !month.equals(""))
			m = Integer.parseInt(month);
		if(Objects.nonNull(year) && !year.equals(""))
			y = Integer.parseInt(year);
	  String date = y +"-"+m+"-";
	  List<Holidays> holidays = this.holidaysRepository.getHolidaysOfMonth(date);
	  return holidays;
	}
	
	
	
	@Override
	public Page<Holidays> getAllHolidays(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize,org.springframework.data.domain.Sort.by(Direction.ASC, "holidayDate"));
		Page<Holidays> holidays = this.holidaysRepository.findAll(page);
		return holidays;

	}

	@Override
	public Boolean deleteHolidays(Integer id) {

		Holidays holidays = this.holidaysRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.HOLIDAYS_NOT_FOUND + id));
		this.holidaysRepository.deleteById(id);
		return true;
	}
	

	// select * from holidays where holiday_date >todayDate limit 1;
	
	@Override
	public EmployeeDashboardResponse EmployeeDashboardTodyaHoliday() {
	
	
		 List<Holidays> holidays = this.holidaysRepository.fetchEmployeeDashboardDetailsHoliday(LocalDate.now());
		
	
		EmployeeDashboardResponse response = new EmployeeDashboardResponse();
//		details.forEach(object->{
//			
//			response.setUpcmingHoliday((String)details.get(0)[0]);
//		
//									
//		});
		
		
		return response;
	}
	

}
