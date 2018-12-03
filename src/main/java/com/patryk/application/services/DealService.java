package com.patryk.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.patryk.application.models.Deal;
import com.patryk.application.repositories.CategoriesRepository;
import com.patryk.application.repositories.DealsRepository;

@Service
public class DealService {
	@Autowired
	private DealsRepository dealsRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	public List<Deal> getAllDeals() {

		List<Deal> deals = new ArrayList<>();
		dealsRepository.findAll().forEach(deals::add);
		return deals;
	}

	public void addNewDeal(Deal deal) {
		
		deal.setCategory(categoriesRepository.findBycategoryID(deal.categoryID));
		dealsRepository.save(deal);
		

	}
}
