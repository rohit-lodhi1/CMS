package com.dollop.app.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	public Optional<Users> findByfirstName(String firstName);

	public Optional<Users> findByjobTitle(String jobTitle);

	public Page<Users> findByDeleted(Pageable page, Boolean deleted);
	
	public Page<Users> findByDeletedAndEmailNot(Pageable page, Boolean deleted, String meail);

	public Page<Users> findByUserRolesInAndDeleted(Pageable pageable, Set<UserRoles> userType, Boolean deleted);

	public Optional<Users> findByIdAndDeleted(Integer id, boolean b);

	@Query(value = "SELECT 'projects' as projects, COUNT(*) as count FROM projects " + "UNION ALL "
			+ "SELECT 'clients' as clients, COUNT(*) as count FROM clients " + "UNION ALL "
			+ "SELECT 'tasks' as tasks, COUNT(*) as count FROM tasks " + "UNION ALL "
			+ "SELECT 'user_roles' as user_roles, COUNT(*) as count FROM user_roles where role_id=2;", nativeQuery = true)
	public List<Object[]> fetchAdminDashboardDetails();

//	SELECT Count(*) from attendance a where a.in_time LIKE %:date% order by a.in_time limit 1"
	@Query(value = "SELECT 'projects' as projects,  COUNT(*) as projectTotal,SUM(CASE WHEN p.status = 'Completed' THEN 1 ELSE 0 END) AS projectstatus  FROM projects p UNION ALL "
			+ "			SELECT 'invoices' as invoives,   COUNT(*) as invoiceTotal , SUM(CASE WHEN i.status != 'Paid' THEN 1 ELSE 0 END) AS pendingInvoice "
			+ "			FROM Invoices i UNION ALL "
			+ "			SELECT 'tickets' as tickets, COUNT(*) as ticketstotal  , SUM(CASE WHEN t.status = 'Open' THEN 1 ELSE 0 END) AS openTickets  "
			+ "			 FROM Tickets t where t.deleted=false  UNION ALL "
			+ "			SELECT 'tickets' as tickets, COUNT(*) as ticketstotal  , SUM(CASE WHEN t.status = 'Closed' THEN 1 ELSE 0 END) AS openTickets  "
			+ "			 FROM Tickets t where t.deleted=false   UNION ALL"
			+ "      SELECT 'attendance' as attendance, COUNT(*) as totalEmployees  , SUM(CASE WHEN  Date(a.in_time)=Date(?1)THEN 1 ELSE 0 END ) AS absentEmployee  "
			+ "		 FROM attendance a where Date(a.in_time)=Date(?1)    ", nativeQuery = true)
	public List<Object[]> fetchAdminDashboardStatistics(LocalDate date);

	public Optional<Users> findByEmail(String email);

	@Query("Select u.Id from Users as u where u.email=:email")
	public Optional<Integer> getIdByEmail(String email);

	@Query(value = "select count(*) from projects p inner join project_members pm on pm.project_id_id=p.id  WHERE pm.user_id_id =:userId"
			+ " UNION ALL " + "select count(*) from tasks t WHERE t.assigned_to_id=:userId and t.status=:status"
			+ " UNION ALL " + "select count(*) from tasks t WHERE t.assigned_to_id=:userId ", nativeQuery = true)

	public List<Object[]> fetchEmployeeDashboardDetails(Integer userId, String status);

//	@Query(value="SELECT sum(net_salary) as totalOutcome FROM `staff_salary` UNION ALL \r\n"
//			+ "select sum(grand_total) as totalIncome from invoices",nativeQuery = true)
//	public List<Object[]> fetchAdminChartData();

//	@Query(value = "SELECT 'net_salary' AS netSalary, COALESCE(sum(net_salary), 0) AS salary ,year(payment_date) as paymentYear FROM staff_salary WHERE YEAR(payment_date) = :year"
//			+ "        UNION ALL SELECT 'amount' AS amount, COALESCE(sum(amount), 0) AS amount,year(payment_date) as billDate FROM invoice_payments WHERE YEAR(payment_date) = :year"
//			+ "       UNION ALL SELECT 'net_salary' AS type, COALESCE(sum(net_salary), 0) AS salary,year(payment_date) as paymentYear FROM staff_salary WHERE YEAR(payment_date) = YEAR(CURDATE() - INTERVAL 1 YEAR) "
//			+ "        UNION ALL SELECT 'amount' AS amount,COALESCE(sum(amount), 0) AS amount,year(payment_date) as billDate FROM invoice_payments WHERE YEAR(payment_date) = YEAR(CURDATE() - INTERVAL 1 YEAR) "
//			+ "        UNION ALL SELECT 'net_salary' AS type, COALESCE(sum(net_salary), 0) AS salary,year(payment_date) as paymentYear FROM staff_salary WHERE YEAR(payment_date) BETWEEN YEAR(CURDATE() - INTERVAL 5 YEAR) AND YEAR(CURDATE()) group By year(payment_date)"
//			+ "        UNION ALL SELECT 'amount' AS amount, COALESCE(sum(amount), 0) AS amount,year(payment_date) as billDate FROM invoice_payments WHERE YEAR(payment_date) BETWEEN YEAR(CURDATE() - INTERVAL 5 YEAR) AND YEAR(CURDATE())", nativeQuery = true)
//	public Object[] fetchAdminChartData(@Param("year") int year);

	@Query(value = "SELECT 'amount' AS category, \r\n" + "       IF(SUM(amount) IS NULL, 0, SUM(amount)) AS amount,\r\n"
			+ "       YEAR(payment_date) AS billDate \r\n" + "FROM invoice_payments \r\n"
			+ "WHERE YEAR(payment_date) BETWEEN YEAR(CURDATE() - INTERVAL 4 YEAR) AND YEAR(CURDATE())\r\n"
			+ "GROUP BY YEAR(payment_date)\r\n" + "\r\n" + "UNION ALL\r\n" + "\r\n"
			+ "SELECT 'net_salary' AS category, \r\n"
			+ "       IF(SUM(net_salary) IS NULL, 0, SUM(net_salary)) AS outcome,\r\n"
			+ "       YEAR(payment_date) AS year \r\n" + "FROM staff_salary \r\n"
			+ "WHERE YEAR(payment_date) BETWEEN YEAR(CURDATE() - INTERVAL 4 YEAR) AND YEAR(CURDATE())\r\n"
			+ "GROUP BY YEAR(payment_date)", nativeQuery = true)
	public List<Object[]> fetchAdminChartData();

	@Query(value = " SELECT 'amount' AS category,\r\n"
			+ "       IF(SUM(amount) IS NULL, 0, SUM(amount)) AS amount,\r\n"
			+ "       Month(payment_date) AS billDate\r\n"
			+ "FROM invoice_payments\r\n"
			+ "WHERE (YEAR(payment_date) = YEAR(CURDATE()) AND MONTH(payment_date) = MONTH(CURDATE())) -- Current month\r\n"
			+ "   OR (YEAR(payment_date) = YEAR(CURDATE()) AND MONTH(payment_date) = MONTH(CURDATE() - INTERVAL 1 MONTH)) -- Previous month of the current year\r\n"
			+ "GROUP BY MONTH(payment_date)\r\n"
			+ "\r\n"
			+ "UNION ALL\r\n"
			+ "\r\n"
			+ "SELECT 'users' AS category,\r\n"
			+ "       IF(COUNT(DISTINCT u.id) IS NULL, 0, COUNT(DISTINCT u.id)) AS employees_thisMonth,\r\n"
			+ "       Month(u.created_at) AS created_at\r\n"
			+ "FROM users u\r\n"
			+ "JOIN user_roles ur ON ur.role_id = 2\r\n"
			+ "WHERE (YEAR(u.created_at) = YEAR(CURDATE()) AND MONTH(u.created_at) = MONTH(CURDATE())) -- Current month\r\n"
			+ "   OR (YEAR(u.created_at) = YEAR(CURDATE() ) AND MONTH(u.created_at) = MONTH(CURDATE() - INTERVAL 1 MONTH)) -- Previous month of the current year\r\n"
			+ "GROUP BY MONTH(u.created_at)\r\n"
			+ "\r\n"
			+ "UNION ALL\r\n"
			+ "\r\n"
			+ "SELECT 'expenses' AS category,\r\n"
			+ "       IF(SUM(amount) IS NULL, 0, SUM(amount)) AS expenses_amount,\r\n"
			+ "       Month(expense_date) AS expense_date\r\n"
			+ "FROM expenses\r\n"
			+ "WHERE (YEAR(expense_date) = YEAR(CURDATE()) AND MONTH(expense_date) = MONTH(CURDATE())) -- Current month\r\n"
			+ "   OR (YEAR(expense_date) = YEAR(CURDATE() ) AND MONTH(expense_date) = MONTH(CURDATE() - INTERVAL 1 MONTH)) -- Previous month of the current year\r\n"
			+ "GROUP BY MONTH(expense_date);\r\n"
			+ "", nativeQuery = true)
	public List<Object[]> fetchAdminMonthOverAllStatics();

}