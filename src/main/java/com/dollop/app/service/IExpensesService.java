package com.dollop.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.payload.ExpensesRequest;
import com.dollop.app.entity.payload.ExpensesResponse;
import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;

public interface IExpensesService {
public ExpensesResponse addExpenses(ExpensesRequest expensesRequest,List<MultipartFile> multi);
	
	
	public ExpensesResponse getExpensesById(Integer id);

	public Page<ExpensesResponse> getAllExpenses(Integer pageNo, Integer pageSize);

	public Boolean deleteExpenses(Integer id);

	public ExpensesResponse updateExpensesStatus(Integer id, String status);

	public Page<ExpensesResponse> searchExpenses(Integer pageNo, Integer pageSize,ExpensesRequest expenses);



	ExpensesResponse updateExpense(ExpensesRequest expensesRequest, List<MultipartFile> files);

	
	
	
	}
