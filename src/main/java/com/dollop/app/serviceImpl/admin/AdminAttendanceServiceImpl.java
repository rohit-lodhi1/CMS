package com.dollop.app.serviceImpl.admin;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.payload.admin.AdminAttendanceSearchRequest;
import com.dollop.app.entity.payload.admin.UserAttendanceResponse;
import com.dollop.app.entity.payload.employee.AttendanceResponse;
import com.dollop.app.repository.AttendenceRepository;
import com.dollop.app.service.admin.IAttendenceService;
import com.dollop.app.service.employee.IUsersService;
import com.dollop.app.utils.PageResponse;

@Service
public class AdminAttendanceServiceImpl implements IAttendenceService {

	@Autowired
	private AttendenceRepository attendanceRepository;

	@Autowired
	private IUsersService userService;

	@Autowired
	private com.dollop.app.service.employee.IAttendenceService employeeAttendanceService;

	// get attendance for
//	@Override
//	public Page<Object> getAttendance(Integer pageIndex, Integer pageSize) {

//	  PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);
//	  Page<Object[]> page = this.attendanceRepository.findAttendanceHistoryOfAllUsers(pageRequest);
//	  List<AttendanceResponse> list = new ArrayList<>();
//	 
//	  
//	 page.getContent().stream().forEach(a ->{
//		 
//		 AttendanceResponse attendance = new AttendanceResponse();
//		 attendance.setUserId(this.userService.getUsersById((Integer)a[0]));
//		 attendance.setInTime((Timestamp)a[2]);
//		 attendance.setOutTime((Timestamp)a[3]);
//		list.add(attendance);
//		 
//	 });
//	List<Object> usersList = new ArrayList<>();
//	
//   Map<Integer, List<AttendanceResponse>> collect = list.stream().collect(Collectors.groupingBy(a -> a.getUserId().getId()));
//	 
//	 usersList.add(collect);
//	 return new PageResponse<Object>(usersList,page,list.size());
//		return this.getAttendances(pageIndex, pageSize);
//	}

	public List<String> generateDateOfMonth(int year, int month) {
		YearMonth date = YearMonth.of(year, month);
		List<String> dates = new ArrayList<>();
		int last = date.lengthOfMonth();
		for (int i = 1; i <= last; i++) {

			dates.add(year + "-" + (month < 10 ? "0" + month : month) + "-" + (i < 10 ? "0" + i : i));

		}
		return dates;
	}

	// search filter
	@Override
	public Page<Object> searchAttendances(Integer pageIndex, Integer pageSize, AdminAttendanceSearchRequest request) {
		List<UserAttendanceResponse> userAttendanceList = new ArrayList<>();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();

		PageRequest pageRequest = PageRequest.of(pageIndex, pageSize);

		if (request.getYear().equals(""))
			request.setYear(year + "");
		else
			year = Integer.parseInt(request.getYear());

		if (request.getMonth().equals(""))
			request.setMonth(month + "");
		else
			month = Integer.parseInt(request.getMonth());

		String date = request.getYear() + "-" + request.getMonth() + "-";
		Page<Object[]> page = this.attendanceRepository.findAttendanceHistoryOfAllUsersSearch(pageRequest, date,
				request.getName());
		LocalDate monthHistory = LocalDate.of(year, month, 1);
		List<AttendanceResponse> list = new ArrayList<>();
		int currentMonth = monthHistory.getMonthValue();
		int currentYear = monthHistory.getYear();
		page.getContent().stream().forEach(a -> {

			AttendanceResponse attendance = new AttendanceResponse();
			attendance.setUserId(this.userService.getUsersById((Integer) a[0]));
			attendance.setInTime((Timestamp) a[2]);
			attendance.setOutTime((Timestamp) a[3]);
			list.add(attendance);

		});

		List<Object> usersList = new ArrayList<>();

		Map<Integer, List<AttendanceResponse>> collect = list.stream()
				.collect(Collectors.groupingBy(a -> a.getUserId().getId()));

		for (Map.Entry<Integer, List<AttendanceResponse>> entry : collect.entrySet()) {
			Integer id = entry.getKey();
			Map<LocalDate, Boolean> userPresenceMap = new HashMap<>();
			for (int day = 1; day <= monthHistory.lengthOfMonth(); day++) {
				LocalDate dating = LocalDate.of(currentYear, currentMonth, day);
				boolean isPresent = false;
				for (AttendanceResponse attendance : entry.getValue()) {

					LocalDate attendanceDate = convertTimestampToLocalDate(attendance.getInTime());
					if (attendanceDate.equals(dating)) {
						isPresent = true;
						break;
					}

				}
				userPresenceMap.put(dating, isPresent);
			}
			UserAttendanceResponse userat = new UserAttendanceResponse();
			userat.setUser(this.userService.getUsersById(id));
			userat.setUserAttendance(userPresenceMap);
			userAttendanceList.add(userat);
		}
		usersList.add(userAttendanceList);

		return new PageResponse<>(usersList, page, usersList.size());
	}

	@Override
	public Page<Object> getAttendance(Integer pageNo, Integer pageSize) {
		List<UserAttendanceResponse> userAttendanceList = new ArrayList<>();
		LocalDate today = LocalDate.now();
		int currentMonth = today.getMonthValue();
		int currentYear = today.getYear();

		PageRequest pageRequest = PageRequest.of(pageNo, 20);
		Page<Object[]> page = this.attendanceRepository.findAttendanceHistoryOfAllUsers(pageRequest);
		List<AttendanceResponse> list = new ArrayList<>();

		page.getContent().stream().forEach(f->{
			});
		
		page.getContent().stream().forEach(a -> {

			try {
			AttendanceResponse attendance = new AttendanceResponse();
			attendance.setUserId(this.userService.getUsersById((Integer) a[0]));
			attendance.setInTime((Timestamp) a[2]);
			attendance.setOutTime((Timestamp) a[3]);
			list.add(attendance);
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		List<Object> usersList = new ArrayList<>();

		Map<Integer, List<AttendanceResponse>> collect = list.stream()
				.collect(Collectors.groupingBy(a -> a.getUserId().getId()));

	
		
		for (Map.Entry<Integer, List<AttendanceResponse>> entry : collect.entrySet()) {
			Integer id = entry.getKey();
			
			
			Map<LocalDate, Boolean> userPresenceMap = new HashMap<>();
			for (int day = 1; day <= today.lengthOfMonth(); day++) {
				LocalDate date = LocalDate.of(currentYear, currentMonth, day);
				boolean isPresent = false;
				for (AttendanceResponse attendance : entry.getValue()) {
					LocalDate attendanceDate = convertTimestampToLocalDate(attendance.getInTime());
					if (attendanceDate.equals(date)) {
						isPresent = true;
						break;
					}

				}
				userPresenceMap.put(date, isPresent);
			}
			UserAttendanceResponse userat = new UserAttendanceResponse();
			userat.setUser(this.userService.getUsersById(id));
			userat.setUserAttendance(userPresenceMap);
			userAttendanceList.add(userat);
		}
		usersList.add(userAttendanceList);

		return new PageResponse<>(usersList, page, usersList.size());
	}

	private static LocalDate convertTimestampToLocalDate(Timestamp timestamp) {
		return timestamp.toLocalDateTime().toLocalDate();
	}

}
