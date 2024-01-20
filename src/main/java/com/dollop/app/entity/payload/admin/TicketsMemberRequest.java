package com.dollop.app.entity.payload.admin;

import com.dollop.app.entity.Tickets;
import com.dollop.app.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsMemberRequest {
	private Long id;

	private Tickets tickets;

	private Users followers;

	private Boolean isLeader;

	private Boolean deleted = false;
}
