package com.dollop.app.serviceImpl.employee;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.threeten.extra.DayOfMonth;
import org.threeten.extra.YearWeek;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.employee.AttendanceRequest;
import com.dollop.app.entity.payload.employee.AttendanceResponse;
import com.dollop.app.entity.payload.employee.AttendanceStaticsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.AttendenceRepository;
import com.dollop.app.repository.HolidaysRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IHolidaysService;
import com.dollop.app.service.employee.IAttendenceService;
import com.dollop.app.utils.PageResponse;

@Service
public class EmployeeAttendanceServiceImpl implements IAttendenceService {

	@Autowired
	private AttendenceRepository attendanceRepository;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private IHolidaysService holidayService;

	@Autowired
	private ModelMapper modelMapper;

	public AttendanceResponse attendanceToAttendanceResponse(Attendance attendance) {
		return this.modelMapper.map(attendance, AttendanceResponse.class);
	}

	public Attendance attendanceRequestToAttendance(AttendanceRequest attendanceRequest) {
		return this.modelMapper.map(attendanceRequest, Attendance.class);
	}

	// creating attendance
	@Override
	public AttendanceResponse createAttendance(AttendanceRequest attendanceRequest) {

		Attendance attendance = this.attendanceRequestToAttendance(attendanceRequest);
		attendance.setInTime(new Timestamp(System.currentTimeMillis()));
		attendance = this.attendanceRepository.save(attendance);
		return this.attendanceToAttendanceResponse(attendance);
	}

	// update attendance
	@Override
	public AttendanceResponse updateAttendence(AttendanceRequest attendance) {
		Attendance saved = this.attendanceRepository.findById(attendance.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.ATTENDENCE_NOT_FOUND + attendance.getId()));
		saved.setOutTime(new Timestamp(System.currentTimeMillis()));
		saved.setIsMispunched(false);
		saved = this.attendanceRepository.save(saved);
		return this.attendanceToAttendanceResponse(saved);
	}

	// get attendance by user
	@Override
	public Page<AttendanceResponse> getAttendanceByUserId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Users user = new Users();
		user.setId(id);
		Page<Attendance> page = this.attendanceRepository.findByUserId(pageRequest, user);
		return page.map(p -> this.attendanceToAttendanceResponse(p));
	}

	// get all attendance
	@Override
	public Page<AttendanceResponse> getAllAttendance(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		List<Users> users = this.userRepository.findAll();
//		this.attendanceRepository.findDistinctByUserIdIn(pageRequest,users );
		return null;
	}

	// get attendance by user and month
	@Override
	public Page<AttendanceResponse> getAttendanceofUserByMonth(Integer pageNo, Integer pageSize, Integer id,
			Date monthe) {

		return null;
	}

	@Override
	public Page<AttendanceResponse> getAttendanceAccordingToDate(Integer pageNo, Integer pageSize, Date start,
			Date end) {

		return null;
	}

	// get attendance by id
	@Override
	public AttendanceResponse getAttendanceById(Long id) {
		Attendance attendance = this.attendanceRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ATTENDENCE_NOT_FOUND + id));
		return this.attendanceToAttendanceResponse(attendance);
	}

	// get latest attendance entry of user by id
	public AttendanceResponse getLatestAttendanceByUserId(Integer id) {
//		Timestamp outTime = null;
		Users user = this.userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + id));
		Optional<Attendance> attendance = this.attendanceRepository
				.getAttendanceByInTimeAndOutTimeAndUserId(LocalDate.now().toString(), user.getId());
		if (attendance.isPresent())
			return this.attendanceToAttendanceResponse(attendance.get());

		return null;
	}

	// first in attendance of User According to date
	@Override
	public AttendanceResponse getFirstInTime(String date, Integer id) {
		Optional<Attendance> attendance = this.attendanceRepository.getFirstInTimeByUserId(date, id);

		if (attendance.isPresent())
			return this.attendanceToAttendanceResponse(attendance.get());
		return null;

	}

	// last entry in attendance of User According to date
	public AttendanceResponse getLastOutTime(String date, Integer id) {
		Optional<Attendance> attendance = this.attendanceRepository.getLastOutTimeByUserId(date, id);

		if (attendance.isPresent())
			return this.attendanceToAttendanceResponse(attendance.get());

		return null;
	}

	// get all attendance of user by given date
	@Override
	public List<AttendanceResponse> getAttendanceofDateByUserId(String date, Integer id) {
		List<Attendance> list = this.attendanceRepository.getAttendaceOfDateByUserId(date, id);
		long mili = 0;
		for (Attendance a : list) {
			if (Objects.nonNull(a.getOutTime()))
				mili += a.getOutTime().getTime() - a.getInTime().getTime();
		}
		;
		String s = (TimeUnit.MILLISECONDS.toHours(mili) % 24) + "." + (TimeUnit.MILLISECONDS.toMinutes(mili) % 60);
		List<AttendanceResponse> response = list.stream().map(a -> this.attendanceToAttendanceResponse(a))
				.collect(Collectors.toList());
		if(!response.isEmpty())
		response.get(0).setTotalTime(s);


		return response;
	}

	// get attendance history of user by user id (Chat GPT Kiya tha 'aise m to loop
	// zyada lg rhe the')
	public Page<AttendanceResponse> getAttendanceHistoryOfUserByUserId(Integer pageNo, Integer pageSize, Integer id) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Object[]> queryResult = attendanceRepository.findAttendanceHistoryByEmployeeId(id, pageRequest);

		List<? extends Object> content = queryResult.map((Function<? super Object[], ? extends Object>) result -> {
			Attendance a = new Attendance();

			Timestamp firstIn = (Timestamp) result[1];
			Timestamp lastOut = (Timestamp) result[2];
			a.setInTime(firstIn);
			a.setOutTime(lastOut);
			return a;
		}).getContent();

	

		return new PageResponse<AttendanceResponse>(content.stream()
				.map(a -> this.attendanceToAttendanceResponse((Attendance) a)).collect(Collectors.toList()),
				queryResult, content.size());
	}

	// search filter
	public Page<AttendanceResponse> searchAttandance(Integer pageNo, Integer pageSize, String time, Integer userId) {
		// setting example
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Object[]> queryResult;
		if (userId != 0)
			queryResult = attendanceRepository.findAttendanceHistoryByEmployeeIdByInTime(userId, pageRequest, time);
		else
			queryResult = attendanceRepository.findAttendanceHistoryOfAllUsers(pageRequest);
		List<? extends Object> content = queryResult.map((Function<? super Object[], ? extends Object>) result -> {
			Attendance a = new Attendance();
			Users user = new Users();
			Timestamp firstIn = (Timestamp) result[1];
			Timestamp lastOut = (Timestamp) result[2];

			a.setInTime(firstIn);
			a.setOutTime(lastOut);
			user.setId(userId);
			a.setUserId(user);
			return a;
		}).getContent();
		List<Attendance> collect = (List<Attendance>) content.stream().map(a -> a).collect(Collectors.toList());

//		collect.removeIf(new Predicate<Attendance>() {
//			@Override
//			public boolean test(Attendance t) {
//				return !t.getInTime().toString().contains(time);
//			}
//		});
		return new PageResponse<AttendanceResponse>(collect.stream()
				.map(a -> this.attendanceToAttendanceResponse((Attendance) a)).collect(Collectors.toList()),
				queryResult, content.size());

	}
	
	
	

	// marking mispunch if user didn't checkout
	public void checkIsLastDayMisPunched(String email) {
		Users user = this.userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + email));
		LocalDate yesterday = LocalDate.now().minusDays(1);
		Optional<Attendance> attendance = this.attendanceRepository
				.getAttendanceByInTimeAndOutTimeAndUserId(yesterday.toString(), user.getId());
		if (attendance.isPresent())
			attendance.get().setIsMispunched(true);
		this.attendanceRepository.save(attendance.get());
	}


	
	@Override
	public AttendanceStaticsResponse getAttendanceStaticsByUserId(String email) {
		LocalDateTime date = LocalDateTime.now();
		Map<String, Integer> totalTime = calculateWorkingHours();

		long time = 0;
		Integer userId = this.userRepository.getIdByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND + email));
		
		// calculating today work hours
		List<Attendance> today = this.attendanceRepository.getAttendaceOfDateByUserId(date.toLocalDate().toString(),
				userId);
		for (Attendance e : today) {
			Timestamp inTime = e.getInTime();
			Timestamp outTime = e.getOutTime();
			if (Objects.nonNull(outTime))
				time += outTime.getTime() - inTime.getTime();
		}

		String s = (TimeUnit.MILLISECONDS.toHours(time) % 24) + "." + (TimeUnit.MILLISECONDS.toMinutes(time) % 60);
		AttendanceStaticsResponse response = new AttendanceStaticsResponse();
		response.setToday(s);
		
		// calculating week work hours
		LocalDate now = LocalDate.now();
		YearWeek week = YearWeek.now();
		LocalDate firstDay = week.atDay(DayOfWeek.MONDAY);  
		
		LocalDate lastDay = week.atDay(DayOfWeek.SATURDAY);

		if (firstDay.getMonth() != lastDay.getMonth())
			firstDay = LocalDate.of(lastDay.getYear(), lastDay.getMonth(), AppConstants.MONTH_STARTING_DATE);

		List<Attendance> weekAttendance = this.attendanceRepository.getAttendanceHistoryOfUserBetweenDates(firstDay,
				lastDay, false, userId);
		
		time = 0;
		for (Attendance e : weekAttendance) {
			Timestamp inTime = e.getInTime();
			Timestamp outTime = e.getOutTime();
			if (Objects.nonNull(outTime))
				time += outTime.getTime() - inTime.getTime();

		}
		s = (TimeUnit.MILLISECONDS.toHours(time) % 24) + "." + (TimeUnit.MILLISECONDS.toMinutes(time) % 60);
		response.setWeek(s);
		
		
		// calculating month work hours
		YearMonth of = YearMonth.of(now.getYear(), now.getMonthValue());
		LocalDate lastDate = LocalDate.of(now.getYear(), now.getMonthValue(), of.atEndOfMonth().getDayOfMonth());
		LocalDate startDate = LocalDate.of(now.getYear(), now.getMonthValue(), 1);

		List<Attendance> monthHistory = this.attendanceRepository.getAttendanceHistoryOfUserBetweenDates(startDate,
				lastDate, false, userId);

		time = 0;
		for (Attendance e : monthHistory) {
			Timestamp inTime = e.getInTime();
			Timestamp outTime = e.getOutTime();
			if (Objects.nonNull(outTime))
				time += outTime.getTime() - inTime.getTime();

		}
		s = (TimeUnit.MILLISECONDS.toHours(time) % 24) + "." + (TimeUnit.MILLISECONDS.toMinutes(time) % 60);
		response.setMonth(s);
		
		// calculating missed punches in current month
		Long missed = this.attendanceRepository.getByMisPunchedOfUserBetweenDates(startDate, lastDate, LocalDate.now(),
				true, userId);
		response.setMisPunched(missed + "");
        
		// setting total working hours per day
		response.setDayHours(AppConstants.WORKING_HOURS_PER_DAY.toString());
		
		// setting total working hours of current week
		response.setWeekHours(totalTime.get("WEEK")*AppConstants.WORKING_HOURS_PER_DAY+"");
		
		// setting total working hours of current  month
		response.setMonthHours(totalTime.get("MONTH")*AppConstants.WORKING_HOURS_PER_DAY+"");
		
		// setting remaining working hours of current month
		long hours = TimeUnit.MINUTES.toHours(
				TimeUnit.HOURS.toMinutes(totalTime.get("MONTH")*AppConstants.WORKING_HOURS_PER_DAY) - TimeUnit.MILLISECONDS.toMinutes(time));
		response.setRemaining(hours + "");
		
		return response;
	}

	public Map<String, Integer> calculateWorkingHours(){
		
		Map<String, Integer> values = new HashMap<>();
		
		LocalDate today = LocalDate.now();
		
		YearMonth of = YearMonth.of(today.getYear(), today.getMonthValue());
		
		List<Holidays> holidays = this.holidayService.getHolidaysOfMonth(null,null);
		
		YearWeek week = YearWeek.now();
		
		LocalDate firstDay = week.atDay(DayOfWeek.MONDAY);
		
		LocalDate lastDay = week.atDay(DayOfWeek.FRIDAY);
		
      if(firstDay.getMonth()!=lastDay.getMonth())
    	  firstDay = LocalDate.of(lastDay.getYear(), lastDay.getMonth(), AppConstants.MONTH_STARTING_DATE);
		
      int monthDays=0;
      int weekDays=0;

      // get total working days in week  except holidays
      while(firstDay.getDayOfMonth() <= lastDay.getDayOfMonth()) {
    	  boolean isHoliday = false;
    	  for(Holidays h:holidays) {
    		  if(h.getHolidayDate().toLocalDate().equals(firstDay)) {
    			  isHoliday =true;
    			  
    		  }
    			  
    	  }
    	  if(!isHoliday)
    		  weekDays++;
    	 firstDay= firstDay.plusDays(1);
      }
      System.err.print(weekDays);
      
      // get total working days in current month  except holidays
		for(int i=1 ; i <= of.atEndOfMonth().getDayOfMonth() ; i++) {
			
         LocalDate date  = LocalDate.of(today.getYear(), today.getMonthValue(), i);
         
			if(!date.getDayOfWeek().toString().equals(AppConstants.SUNDAY) && !date.getDayOfWeek().toString().equals(AppConstants.SATURDAY) ) {
				
				boolean isHoliday=false;
				
				for(Holidays h:holidays) {
					if(h.getHolidayDate().toLocalDate().equals(date)) {
						isHoliday =true;
						break;
					}
				}
				if(!isHoliday)
					monthDays++;
			}
		}
	    values.put("WEEK", weekDays);
	    values.put("MONTH", monthDays);
     return values;
	}


}
//LocalDate date  = LocalDate.of(today.getYear(), today.getMonthValue(), i);
//if( !date.getDayOfWeek().toString().equals(AppConstants.SUNDAY) && !date.getDayOfWeek().toString().equals(AppConstants.SATURDAY) ) {
//   
//	for(Holidays h:holidays) {
//      if(!date.equals(h.getHolidayDate().toLocalDate()))     		    		
//		monthDays++;
//	}
//}
//while( !isWeekCalculated && firstDay.getDayOfMonth() <= lastDay.getDayOfMonth() && weekDays<6) {
//	weekDays++;
//	firstDay = firstDay.plusDays(count++);
//	System.out.println(firstDay.getDayOfMonth());
//}
//if(!isWeekCalculated) 
//isWeekCalculated=true;
//			
