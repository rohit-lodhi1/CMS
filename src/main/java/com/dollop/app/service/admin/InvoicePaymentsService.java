package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.payload.InvoicePaymentsRequest;
import com.dollop.app.entity.payload.InvoicePaymentsResponse;
import com.dollop.app.entity.payload.TrainerRequest;
import com.dollop.app.entity.payload.TrainerResponse;

public interface InvoicePaymentsService {
	
	public InvoicePaymentsResponse addInvoicePayments(InvoicePaymentsRequest invoicePaymentsRequest); 
	   
	   public InvoicePaymentsResponse getInvoicePaymentsById(Integer id);
	   
	   public InvoicePaymentsResponse updateInvoicePayments(InvoicePaymentsRequest invoicePaymentsRequest);
	   
	   public Page<InvoicePaymentsResponse> getAllInvoicePayments(Integer pageNo,Integer pageSize);
	
	   public Page<InvoicePaymentsResponse> getAllInoicePaymentOrderByDate();
	   
	   public Boolean deleteTrainers(Integer id);
	   
	   public Page<InvoicePaymentsResponse> getInvoicePaymentsByStatus(Integer pageNo,Integer pageSize,String status);
	
	
	   

}
