package com.dollop.app.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.Leaves;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.employee.AttendanceResponse;
import com.dollop.app.listPayloads.UserListResponse;
import com.dollop.app.repository.InvoicesRepository;
import com.dollop.app.repository.LeavesRepository;
import com.dollop.app.service.IHolidaysService;
import com.dollop.app.service.admin.IUsersService;
import com.dollop.app.service.employee.IAttendenceService;

@Component
public class LeaveCheckSchedular {

	@Autowired
	private IAttendenceService attendenceService;
	@Autowired
	private IUsersService usersService;
	@Autowired
	private IHolidaysService holidaysService;

	@Autowired
	private LeavesRepository leavesRepository;

	@Autowired
	private InvoicesRepository invoicesRepository;

	@Scheduled(cron = "0 0 10 * * MON-FRI")
	public void updateLeavesOfEmployees() {
		List<Holidays> holidays = this.holidaysService.getHolidaysOfMonth(null, null);
		LocalDate now = LocalDate.now();
		boolean isHoliday = false;
		for (Holidays holiday : holidays) {
			if (holiday.getHolidayDate().toLocalDate().equals(now)) {
				isHoliday = true;
			}

		}

		Users u = new Users();
		if (!isHoliday) {
			List<UserListResponse> employee = this.usersService.getAllUserByRole(0, AppConstants.MAX_EMPLOYEE,2,null).getContent();

			employee.stream().forEach(e -> {
				AttendanceResponse attendance = this.attendenceService.getFirstInTime(now.toString(), e.getId());
				if (Objects.isNull(attendance)) {
					Leaves chhutti = new Leaves();
					chhutti.setDate(now);
					u.setId(e.getId());
					chhutti.setEmployee(u);
					this.leavesRepository.save(chhutti);
				}
			});

		}
	}

//	@Scheduled(cron = "0 0 10 * * MON-FRI")
	@Scheduled(cron = "0 0 10 * * ?") // Run daily at 12:25 PM
	public void changeStatusOfInvoiceDate() {
		this.invoicesRepository.changeStatusOfInvoice(LocalDate.now());
	}

}
