package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.PayrollItemsDeductionsRequest;
import com.dollop.app.entity.payload.PayrollItemsDeductionsResponse;

public interface IPayrollItemsDeductionsService {

	public PayrollItemsDeductionsResponse addPayrollItemsDeductions(
			PayrollItemsDeductionsRequest payrollItemsDeductions);

	public PayrollItemsDeductionsResponse getPayrollItemsDeductionssById(Integer id);

	public PayrollItemsDeductionsResponse updatePayrollItemsDeductions(
			PayrollItemsDeductionsRequest payrollItemsDeductions);

	public Page<PayrollItemsDeductionsResponse> getAllPayrollItemsDeductions(Integer pageNo, Integer pageSize);

	public Boolean deletePayrollItemsDeductions(Integer id);

}
