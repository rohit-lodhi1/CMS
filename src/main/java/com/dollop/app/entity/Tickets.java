package com.dollop.app.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
	@ManyToOne
	private Clients client;

	@ManyToOne
	@JoinColumn(name="tickets_id")
	@JsonIgnoreProperties(value = {"tickets"})	
	private TicketTypes ticketTypeId;

	private String title;

	//enum
	private String status="Open";
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="tickets_id_id")
	@JsonIgnoreProperties(value = {"ticketsId"})
	private List<TicketsFiles> ticketsFiles=new ArrayList<>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="ticket_id")
	@JsonIgnoreProperties(value = {"tickets"})	
	private List<TicketsMembers> ticketMembers=new ArrayList<>();

	
	@ManyToOne
	private Users createdBy;

	private Date createdAt;
	@PrePersist
	public void created() {
		this.createdAt = new Date(System.currentTimeMillis());
	}
	
	private Date lastActivityAt;
	private String description;
	
	
	@ManyToOne
	private Users requestedBy;
	
	
	private String labels;
	
	private Boolean deleted=false;
}
