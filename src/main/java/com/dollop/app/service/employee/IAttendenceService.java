package com.dollop.app.service.employee;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.payload.employee.AttendanceRequest;
import com.dollop.app.entity.payload.employee.AttendanceResponse;
import com.dollop.app.entity.payload.employee.AttendanceStaticsResponse;

public interface IAttendenceService {

	public AttendanceResponse createAttendance(AttendanceRequest attendance);
	
	public AttendanceResponse updateAttendence(AttendanceRequest attendance);
	
	public AttendanceResponse getAttendanceById(Long id);
	
	public AttendanceResponse getLatestAttendanceByUserId(Integer id);
	
	public Page<AttendanceResponse> getAttendanceByUserId(Integer pageNo,Integer pageSize,Integer id);
	
	public Page<AttendanceResponse> getAllAttendance(Integer pageNo,Integer pageSize);
	
	public Page<AttendanceResponse> getAttendanceofUserByMonth(Integer pageNo,Integer pageSize,Integer id,Date monthe);
	
	public Page<AttendanceResponse> getAttendanceAccordingToDate(Integer pageNo,Integer pageSize,Date start,Date end);
	
	public AttendanceResponse getFirstInTime(String date,Integer id) ;
	
	public AttendanceResponse getLastOutTime(String date,Integer id);
	
	public List<AttendanceResponse> getAttendanceofDateByUserId(String date,Integer id);
	
	public Page<AttendanceResponse> getAttendanceHistoryOfUserByUserId(Integer pageNo,Integer pageSize,Integer id);
	
	public Page<AttendanceResponse> searchAttandance(Integer pageNo,Integer pageSize,String attendanceRequest,Integer userId);
	
	public AttendanceStaticsResponse getAttendanceStaticsByUserId(String email) ;
}
