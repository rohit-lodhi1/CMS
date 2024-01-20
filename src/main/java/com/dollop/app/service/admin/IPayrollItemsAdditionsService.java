package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.PayrollItemsAdditionsRequest;
import com.dollop.app.entity.payload.PayrollItemsAdditionsResponse;

public interface IPayrollItemsAdditionsService {
	
	
	public PayrollItemsAdditionsResponse addPayrollItemsAdditions(PayrollItemsAdditionsRequest payrollItemsAdditions); 
	   
	   public PayrollItemsAdditionsResponse getPayrollItemsAdditionsById(Integer id);
	   
	   public PayrollItemsAdditionsResponse updatePayrollItemsAdditions(PayrollItemsAdditionsRequest payrollItemsAdditions);
	   
	   public Page<PayrollItemsAdditionsResponse> getAllPayrollItemsAdditions(Integer pageNo,Integer pageSize);
	   
	   public Boolean deletePayrollItemsAdditions(Integer id);


}
