package com.dollop.app.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.Expenses;
import com.dollop.app.entity.ExpensesFiles;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.payload.ExpensesRequest;
import com.dollop.app.entity.payload.ExpensesResponse;
import com.dollop.app.entity.payload.GoalListRequest;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ExpensesRepository;
import com.dollop.app.service.IExpensesService;

@Service
public class ExpensesServiceImpl implements IExpensesService{

	@Autowired
	public ExpensesRepository expensesRepository;

	@Autowired
	private ModelMapper modelMapper;
	

	@Value("${expenses.file.path}")
	public   String DIRECTORY ;

	public ExpensesResponse expensesToExpensesResponse(Expenses expenses) {
		return this.modelMapper.map(expenses, ExpensesResponse.class);
	}

	public Expenses expensesRequestToExpenses(ExpensesRequest expensesRequest) {
		return this.modelMapper.map(expensesRequest, Expenses.class);
	}

	@Override
	public ExpensesResponse addExpenses(ExpensesRequest expensesRequest,List<MultipartFile> files) {
		Expenses expenses = this.expensesRequestToExpenses(expensesRequest);
		List<ExpensesFiles> expensesFiles = new ArrayList<>();
		if(files!=null)
		     files.forEach(a->{
		    	 ExpensesFiles pf = new ExpensesFiles();
			 pf.setCreatedAt(new Date(System.currentTimeMillis()));
			 pf.setOriginalName(a.getOriginalFilename());
			 pf.setFileSize((double)a.getSize());
			
			 pf.setFileName(UUID.randomUUID().toString()+a.getOriginalFilename());
			 
			 // system file upload
			 String fileName =StringUtils.cleanPath(pf.getFileName());
			
				Path path = Paths.get(System.getProperty("user.dir")+DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				expensesFiles.add(pf);
			 
			 
			 });
		expenses.setExpensesFiles(expensesFiles);
		 expenses =this.expensesRepository.save(expenses);
		
		return this.expensesToExpensesResponse(expenses);
	}

	// update project
	@Override
	public ExpensesResponse updateExpense(ExpensesRequest expensesRequest,List<MultipartFile> files) {
		
		 Expenses expenses = this.expensesRepository.findById(expensesRequest.getId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.EXPENSES_NOT_FOUNND+expensesRequest.getId()));
		 expenses.setAmount(expensesRequest.getAmount());
		 expenses.setDescription(expenses.getDescription());
		 expenses.setExpenseDate(expensesRequest.getExpenseDate());
		 expenses.setPaidBy(expensesRequest.getPaidBy());
		 expenses.setTitle(expensesRequest.getTitle());
		List<ExpensesFiles> expensesFiles = expenses.getExpensesFiles();
		if(files!=null) {

		     files.forEach(a->{
		    	 
		     ExpensesFiles pf = new ExpensesFiles();
			 pf.setCreatedAt(new Date(System.currentTimeMillis()));
			 pf.setOriginalName(a.getOriginalFilename());
			 pf.setFileSize((double)a.getSize());
			
			 pf.setFileName(UUID.randomUUID().toString()+a.getOriginalFilename());
			 
			 // system file upload
			 String fileName =StringUtils.cleanPath(pf.getFileName());
					Path path = Paths.get(System.getProperty("user.dir")+DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {

					e.printStackTrace();
				}
				expensesFiles.add(pf);
			 
			 
			 });
		}
		expenses.setExpensesFiles(expensesFiles);
		 expenses =this.expensesRepository.save(expenses);
			
		return this.expensesToExpensesResponse(expenses);
	}


	@Override
	public ExpensesResponse getExpensesById(Integer id) {
	Expenses expenses = this.expensesRepository.findByIdAndDeleted(id,false).orElseThrow(() -> new ResourceNotFoundException(AppConstants.EXPENSES_NOT_FOUNND+id));	
		
		return this.expensesToExpensesResponse(expenses);
	}

	@Override
	public Page<ExpensesResponse> getAllExpenses(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Expenses> page = this.expensesRepository.findByDeleted(pageRequest,false);
       
		return page.map( p -> this.expensesToExpensesResponse(p));
	}

	@Override
	public Boolean deleteExpenses(Integer id) {
		Expenses expenses = this.expensesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.EXPENSES_NOT_FOUNND+id));
		expenses.setDeleted(true);
		this.expensesRepository.save(expenses);
		return true;
}

	@Override
	public ExpensesResponse updateExpensesStatus(Integer id, String status) {
		Expenses expenses = this.expensesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.EXPENSES_NOT_FOUNND+id));
		expenses.setStatus(status);
		this.expensesRepository.save(expenses);
		return this.expensesToExpensesResponse(expenses);
	}

	@Override
	public Page<ExpensesResponse> searchExpenses(Integer pageNo, Integer pageSize, ExpensesRequest expensesRequest) {
	
		expensesRequest.setAmount(null);
		
		expensesRequest.getUserId().setDesignation(null);
		expensesRequest.setUserId(null);
	
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
			
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id)));// for
		
		Example<Expenses> example = Example.of(this.expensesRequestToExpenses(expensesRequest), matcher);
		PageRequest pageable = PageRequest.of(pageNo, pageSize);

		Page<Expenses> page = this.expensesRepository.findAll(example, pageable);
			
		 return page.map( u -> this.expensesToExpensesResponse(u));
	}

	}

	
	
	
	
	



