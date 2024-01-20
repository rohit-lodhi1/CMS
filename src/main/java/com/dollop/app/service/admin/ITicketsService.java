package com.dollop.app.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.Tickets;
import com.dollop.app.entity.TicketsFiles;
import com.dollop.app.entity.payload.TicketTypeRequest;
import com.dollop.app.entity.payload.TicketTypeResponse;
import com.dollop.app.entity.payload.TicketsRequest;
import com.dollop.app.entity.payload.TicketsResponse;

public interface ITicketsService {
	
	
	
	public  TicketsResponse addTickets(TicketsRequest ticketsRequest,List<MultipartFile> file, String string);
	
	public  Tickets ticketsRequestToTickets(TicketsRequest ticketsRequest) ;
	
	

	public TicketsResponse updateTickets(TicketsRequest tickets);

	public Page<TicketsResponse> getAllTickets(Integer pageNo, Integer pageSize);

	public TicketsResponse getTicketsById(Integer id);

	public Boolean deleteTickets(Integer id);

	  public Page<TicketsResponse> searchTickets(Integer pageNo,Integer pageSize,TicketsRequest tickets);


	  public	TicketsResponse changeTicketsStatus(Integer id, String status,String ofType);
	 
	  public	ResponseEntity<Resource> downloadFile(Long id);

	  public	Boolean deleteTicketFilesByTicketFileId(Long id);
	   public List<TicketsFiles> addTicketFile(List<MultipartFile> files,Integer projectId,String uploadedBy); 
	   public Boolean deleteTicketFileById(Long id);

	   
	   public ResponseEntity<Object> getAllStaticsOfTickets();
		 
}
