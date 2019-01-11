package com.patryk.application.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public List<DealDTO> getAllDeals() {
		List<Deal> deals = dealService.getAllDeals();
		List<DealDTO> dealsDTO = new ArrayList<>();
		for (Deal x : deals) {

			dealsDTO.add(modelMapper.map(x, DealDTO.class));
		}
		return dealsDTO;
	}

	@GetMapping("/deals/{id}")
	public Deal getDeal(@PathVariable Integer id) {
		return dealService.getDeal(id);

	}

	@PostMapping("/deal")
	public void addNewDeal(@RequestBody DealDTO dealDTO) {

		Deal deal = modelMapper.map(dealDTO, Deal.class);

		dealService.addNewDeal(deal);

	}

	@PutMapping("/deal")
	public void updateDealScore(@RequestBody DealDTO dealDTO) {

		Deal deal = modelMapper.map(dealDTO, Deal.class);

		dealService.updateScore(deal);

	}

	@GetMapping("/deals/search/desc/{text}")
	public List<DealDTO> getDealsByDesc(@PathVariable String text) {
		List<Deal> deals = dealService.getDealByDesc(text);
		List<DealDTO> dealsDTO = new ArrayList<>();
		for (Deal x : deals) {

			dealsDTO.add(modelMapper.map(x, DealDTO.class));
		}
		return dealsDTO;
	}
	@GetMapping("/deals/search/name/{name}")
	public List<DealDTO> getDealsByName(@PathVariable String name) {
		List<Deal> deals = dealService.getDealByName(name);
		List<DealDTO> dealsDTO = new ArrayList<>();
		for (Deal x : deals) {

			dealsDTO.add(modelMapper.map(x, DealDTO.class));
		}
		return dealsDTO;
	}
	@GetMapping("/deals/search/cat/{categoryID}")
	public List<DealDTO> getDealsByCat(@PathVariable Integer categoryID) {
		List<Deal> deals = dealService.getDealByCat(categoryID);
		List<DealDTO> dealsDTO = new ArrayList<>();
		for (Deal x : deals) {

			dealsDTO.add(modelMapper.map(x, DealDTO.class));
		}
		return dealsDTO;
	}
}
