package com.dollop.app.service.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.admin.TicketsMemberRequest;
import com.dollop.app.entity.payload.admin.TicketsMemberResponse;

public interface ITicketsMemberService {

	public List<TicketsMemberResponse> addTicketsMember(List<TicketsMemberRequest> memberRequest);

	public TicketsMemberResponse updateTicketsMember(TicketsMemberRequest memberRequest);

	public TicketsMemberResponse getTicketsMemberById(Long id);

	public Page<TicketsMemberResponse> getTicketsMemberByTicketId(Integer pageNo, Integer pageSize, Integer id);

	public Page<TicketsMemberResponse> getTicketsMemberByUserId(Integer pageNo, Integer pageSize, Integer id);

	public Boolean deleteTicketsMember(Long id);

	public TicketsMemberResponse makeLeaderForTicket(TicketsMemberRequest memberRequest);



}
