package com.ashu.spring.mysql.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.spring.mysql.api.dao.TicketDao;
import com.ashu.spring.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketDao dao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		for(Ticket t : tickets) {
			System.out.print(t);
		}
		/*
		 * Ticket t1 = new Ticket(200,"Movie"); Ticket t2 = new
		 * Ticket(300,"Destination"); tickets = new ArrayList(); tickets.add(t1);
		 * tickets.add(t2);
		 */
		dao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}
	
	@GetMapping("/getTickets")
	public List<Ticket> getTickets(){
		return (List<Ticket>)dao.findAll();
	}
}
