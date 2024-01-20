package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.PayrollItemsOvertimeRequest;
import com.dollop.app.entity.payload.PayrollItemsOvertimeResponse;

public interface IPayrollItemsOvertimeService {
	

	public PayrollItemsOvertimeResponse addPayrollItemsOvertime(
			PayrollItemsOvertimeRequest payrollItemsOvertime);

	public PayrollItemsOvertimeResponse getPayrollItemsOvertimeById(Integer id);

	public PayrollItemsOvertimeResponse updatePayrollItemsOvertime(
			PayrollItemsOvertimeRequest payrollItemsOvertime);

	public Page<PayrollItemsOvertimeResponse> getAllPayrollItemsOvertime(Integer pageNo, Integer pageSize);

	public Boolean deletePayrollItemsOvertime(Integer id);


}
