package com.dollop.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TicketTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String title;
	
	private String description;
	
	@OneToMany
	@JoinColumn(name="ticket_type_id")
	@JsonIgnoreProperties(value = {"ticketTypeId"})	
	private List<Tickets> tickets;
	
	private Boolean isDeleted;
}
