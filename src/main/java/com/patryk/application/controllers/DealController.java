package com.patryk.application.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patryk.application.dto.DealDTO;
import com.patryk.application.models.Deal;
import com.patryk.application.services.DealService;

@RestController
public class DealController {
	private static final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private DealService dealService;

	@GetMapping("/deals")
	public List<Deal> getAllDeals() {
		return dealService.getAllDeals();

	}

	@PostMapping("/deals")
	public void addNewDeal(@RequestBody DealDTO dealDTO) {
		Deal deal = modelMapper.map(dealDTO, Deal.class);
		dealService.addNewDeal(deal);

	}

}
