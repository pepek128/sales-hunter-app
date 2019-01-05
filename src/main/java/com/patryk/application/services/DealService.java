package com.patryk.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patryk.application.models.Category;
import com.patryk.application.models.Deal;
import com.patryk.application.repositories.CategoriesRepository;
import com.patryk.application.repositories.DealsRepository;

@Service
public class DealService {
	@Autowired
	private DealsRepository dealsRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;

	public List<Deal> getAllDeals() {

		List<Deal> deals = new ArrayList<>();
		dealsRepository.findAll().forEach(deals::add);
		return deals;
	}

	public void addNewDeal(Deal deal) {

		deal.setCategory(categoriesRepository.findBycategoryID(deal.getCategoryID()));
		dealsRepository.save(deal);

	}

	public Deal getDeal(Integer id) {
		return dealsRepository.getOne(id);

	}

	public void updateScore(Deal deal) {
		dealsRepository.save(deal);

	}

	public List<Deal> getDealByDesc(String text) {
		return dealsRepository.findByDescriptionContainingIgnoreCase(text);
	}
	public List<Deal> getDealByName(String name) {
		return dealsRepository.findByNameContainingIgnoreCase(name);
	}
	public List<Deal> getDealByCat(Integer categoryID) {
		
		return dealsRepository.findByCategory(categoriesRepository.findById(categoryID));
	}
}
