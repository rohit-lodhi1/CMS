package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dollop.app.entity.InvoicesItems;
import com.dollop.app.entity.payload.ClientsResponse;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.InvoicesResponse;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;

public interface IInvoicesService {
	public InvoicesResponse addInvoices(InvoicesRequest invoices);

	public InvoicesResponse updateInvoices(InvoicesRequest invoices);
	
	public InvoicesResponse createInvoiceItemByInvoiceItems(Integer id);

	
	public Page<InvoicesResponse> getAllInvoices(Integer pageNo, Integer pageSize);
	public Page<InvoicesResponse> getAllInvoicesOrderByDate();


	public Boolean deleteInvoices(Integer id);
	public Page<InvoicesResponse> searchInvoices(Integer pageNo, Integer pageSize, InvoicesRequest invoices);
	
	
	

	public	InvoicesResponse getInvoicesById(Integer id);


}
