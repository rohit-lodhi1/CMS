package com.dollop.app.entity.payload;

import java.sql.Date;
import java.util.List;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.TicketsFiles;
import com.dollop.app.entity.TicketsMembers;
import com.dollop.app.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TicketsRequest {
	private Integer id;

	private Clients client;
	private TicketTypes ticketTypeId;

	private String title;

	// enum
	private String status;

	private List<TicketsFiles> ticketsFiles;

	private List<TicketsMembers> ticketMembers;

	private String description;

	private Users requestedBy;

	private String labels;

	private Boolean deleted = false;
}
