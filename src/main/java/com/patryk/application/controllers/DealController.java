package com.patryk.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patryk.application.models.Deal;
import com.patryk.application.services.DealService;

@RestController
public class DealController {

	@Autowired
	private DealService dealService;

	

	@GetMapping("/deals")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Deal> getAllDeals() {
		return dealService.getAllDeals();

	}

	@PostMapping("/deals")
	@CrossOrigin(origins = "http://localhost:4200")
	public void addNewDeal(@RequestBody Deal deal) {
		dealService.addNewDeal(deal);
		
	

	}

}
