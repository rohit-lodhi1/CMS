package com.dollop.app.repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.Users;

public interface AttendenceRepository extends JpaRepository<Attendance, Long>{
    
	public Page<Attendance> findByUserId(PageRequest pageRequest,Users user);
//	@Query("select  DISTINCT(user_id)  from attendance where Month(in_time) In (select Month(:time) as month from attendance)")
//	public Page<Attendance> getAttendenceOfMonth(String time);

	public	Optional<Attendance> findByIdAndDeleted(Long id, boolean b);
	
	public Optional<Attendance> findByInTimeLikeAndOutTimeAndUserId(Timestamp inTime,Timestamp outTime,Users userId);
	
	@Query(value="Select  * from attendance as a where a.in_time Like %:inTime% And a.out_time is Null And a.user_id_id = :userId",nativeQuery=true)
	public Optional<Attendance> getAttendanceByInTimeAndOutTimeAndUserId(String inTime,Integer userId);
	
	@Query(value="SELECT * FROM  attendance as a where a.user_id_id = :id and a.in_time LIKE %:date% order by a.in_time limit 1",nativeQuery = true)
	public Optional<Attendance> getFirstInTimeByUserId(String date,Integer id);
	
	@Query(value="SELECT Count(distinct(a.user.id)) from attendance a where date(a.in_time) =date(:date) group by a",nativeQuery = true)
	public Optional<Integer> getCountOfEmployeePresentByDate(LocalDate date);
	
	@Query(value = "SELECT * FROM  attendance as a where a.user_id_id = :id and a.out_time LIKE %:date% order by a.out_time desc limit 1",nativeQuery = true)
	public Optional<Attendance> getLastOutTimeByUserId(String date,Integer id);
	
	@Query(value="SELECT * FROM  attendance as a where a.user_id_id = :id and a.in_time LIKE %:date% order by a.in_time ",nativeQuery = true)
	public List<Attendance> getAttendaceOfDateByUserId(String date,Integer id);
	
	@Query("SELECT FUNCTION('DATE', a.inTime) AS date, MIN(a.inTime) AS firstInTime, MAX(a.outTime) AS lastOutTime " +
	           "FROM Attendance a " +
	           "WHERE a.userId.id = :employeeId And a.inTime like %:time%" +
	           "GROUP BY FUNCTION('DATE', a.inTime)")
	public  Page<Object[]> findAttendanceHistoryByEmployeeIdByInTime(Integer employeeId,Pageable pageable,String time);
	
	@Query("SELECT FUNCTION('DATE', a.inTime) AS date, MIN(a.inTime) AS firstInTime, MAX(a.outTime) AS lastOutTime " +
	           "FROM Attendance a " +
	           "WHERE a.userId.id = :employeeId " +
	           "GROUP BY FUNCTION('DATE', a.inTime)")
	public  Page<Object[]> findAttendanceHistoryByEmployeeId(Integer employeeId,Pageable pageable);
	
	@Query(value="SELECT a.user_id_id ,DATE( a.in_time) AS date, MIN(a.in_time) AS firstInTime, MAX(a.out_time) AS lastOutTime FROM Attendance a where a.user_id_id in (Select id from users) GROUP BY a.in_time order by a.user_id_id",nativeQuery = true)
	public Page<Object[]> findAttendanceHistoryOfAllUsers(Pageable pageable);
	
	
	@Query("SELECT a.userId.id ,FUNCTION('DATE', a.inTime) AS date,  MIN(a.inTime) AS firstInTime, MAX(a.outTime) AS lastOutTime " +
	           "FROM Attendance a where a.inTime Like %:date% And concat(a.userId.firstName,' ',a.userId.lastName) Like %:name% " +
	           
	           "GROUP BY FUNCTION('DATE', a.inTime) order by a.userId.id")
	public Page<Object[]> findAttendanceHistoryOfAllUsersSearch(Pageable pageable,String date,String name);
	
	
	
	@Query("select a.userId.id from Attendance a ")
	public List<Integer> getDistinctUserId();
	
	
	
	
	
	
//	  @Query(nativeQuery = true, value =
//	            "SELECT " +
//	            "    a.user_id_id AS user_id, " +
//	            "    DATE_FORMAT(all_dates.dates, '%Y-%m-%d') AS attendance_date, " +
//	            "    CASE WHEN COUNT(a.id) > 0 THEN true ELSE false END AS is_present " +
//	            "FROM " +
//	            "    (SELECT " +
//	            "        :year_month - INTERVAL (a.number) DAY AS dates " +
//	            "    FROM " +
//	            "        (SELECT 0 AS number UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 " +
//	            "        UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 " +
//	            "        UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11) a) all_dates " +
//	            "CROSS JOIN " +
//	            "    users u " +
//	            "LEFT JOIN " +
//	            "    attendance a " +
//	            "ON " +
//	            "    u.id = a.user_id_id " +
//	            "    AND DATE(a.in_time) = DATE(all_dates.dates) " +
//	            "    AND YEAR(a.in_time) = YEAR(all_dates.dates) " +
//	            "    AND MONTH(a.in_time) = MONTH(all_dates.dates) " +
//	            "WHERE " +
//	            "    YEAR(all_dates.dates) = YEAR(:year_month) " +
//	            "    AND MONTH(all_dates.dates) = MONTH(:year_month) " +
//	            "GROUP BY " +
//	            "    u.id, " +
//	            "    DATE_FORMAT(all_dates.dates, '%Y-%m-%d')")
//	 public List<Map<String, Object>> getAttendanceForMonthAndYear(@Param("year_month") String yearMonth);
	
	@Query(value="select * from attendance a where a.in_time BETWEEN :startDate and :endDate and a.is_mispunched=:isMisPunched  and a.user_id_id =:id" ,nativeQuery = true)
	public List<Attendance> getAttendanceHistoryOfUserBetweenDates(LocalDate startDate,LocalDate endDate,boolean isMisPunched,Integer id);
	

	// @Query(value = "select count(*) from attendance a where a.in_time between :startDate and :endDate and a.is_mispunched=:isMisPunched and a.user_id_id =:id",nativeQuery = true)
	// public Long getByMisPunchedOfUserBetweenDates(LocalDate startDate,LocalDate endDate ,boolean isMisPunched,Integer id);

	@Query(value = "select count(*) from attendance a where a.in_time between :startDate and :endDate and a.is_mispunched=:isMisPunched and a.in_time  not Like %:todayDate%  and a.user_id_id =:id",nativeQuery = true)
	public Long getByMisPunchedOfUserBetweenDates(LocalDate startDate,LocalDate endDate ,LocalDate todayDate,boolean isMisPunched,Integer id);
	
	

}
