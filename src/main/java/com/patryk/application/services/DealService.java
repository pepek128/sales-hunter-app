package com.patryk.application.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patryk.application.models.Deal;
import com.patryk.application.models.User;
import com.patryk.application.repositories.CategoriesRepository;
import com.patryk.application.repositories.DealsRepository;
import com.patryk.application.repositories.UserRepository;

@Service
public class DealService {
	@Autowired
	private DealsRepository dealsRepository;
	@Autowired
	private CategoriesRepository categoriesRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Deal> getAllDeals() {

		List<Deal> deals = new ArrayList<>();
		dealsRepository.findAll().forEach(deals::add);
		return deals;
	}

	public void addNewDeal(Deal deal) {

		deal.setCategory(categoriesRepository.findBycategoryID(deal.getCategoryID()));
		deal.setUser(userRepository.findByUsernameIgnoreCase(deal.getUsername()));
		dealsRepository.save(deal);

	}

	public Deal getDeal(Integer id) {
		return dealsRepository.getOne(id);

	}

	/*
	 * public void updateScore(Deal deal) {
	 * 
	 * User pom1 = userRepository.findByUsernameIgnoreCase(deal.getVoted()); Deal
	 * pom = dealsRepository.getOne(deal.getDealID()); List<User> votedusers =
	 * pom.getVotedusers(); votedusers.add(pom1); deal.setVotedusers(votedusers);
	 * dealsRepository.save(deal);
	 * 
	 * }
	 */
	public void updateScore(String voted, Integer id, Integer score) {

		User pom1 = userRepository.findByUsernameIgnoreCase(voted);
		Deal pom = dealsRepository.getOne(id);
		pom.setScore(score);
		List<User> votedusers = pom.getVotedusers();
		votedusers.add(pom1);
		pom.setVotedusers(votedusers);

		dealsRepository.save(pom);

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

	public List<Deal> getRecommendedDeals(String username) {
		List<Deal> votedDeals = dealsRepository.findByVotedusers_username(username);
		List<Deal> addedDeals = dealsRepository.findByUser_username(username);
		List<Deal> reccDeals = new ArrayList<>();

		List<String> categories = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();
		int i = 0;
		for (Deal x : addedDeals) {
			ids.add(x.getDealID());
		}
		for (Deal x : votedDeals) {

			if (categories.contains(x.category.getCategory_name())) {
				int pom = 0;
				i = categories.indexOf(x.category.getCategory_name());
				categories.add(x.category.getCategory_name());
				categories.remove(i);

			} else {
				categories.add(x.category.getCategory_name());
			}
			System.out.println("Deal który zvotował " + x.getName());
			System.out.println("Kategoria zwotowanego deala " + x.category.getCategory_name());

			ids.add(x.getDealID());
		}
		i = 0;
		categories = getNewest(categories);
		for (String x : categories) {			
			reccDeals.addAll(dealsRepository.findFirst2ByDealIDNotInAndCategory_categorynameOrderByDealIDDesc(ids, x));

		}
		categories.clear();
		return reccDeals;

	}

	public List<String> getNewest(List<String> categories) {

		if (!categories.isEmpty()) {
			if (categories.size() >= 2) {
				String pom1;
				String pom2;
				pom1 = categories.get(categories.size() - 1);
				pom2 = categories.get(categories.size() - 2);
				categories.set(0, pom1);
				categories.set(1, pom2);
				return categories.subList(0, 2);
			}

		}
		return categories;

	}

	public void updateDeal(Deal deal) {
		Deal pom = dealsRepository.getOne(deal.getDealID());
		deal.setUser(pom.getUser());
		dealsRepository.save(deal);

	}

	public void delete(Integer id) {
		dealsRepository.delete(dealsRepository.getOne(id));

	}

	public Deal getDealByImage(String image) {
		return dealsRepository.findByImage(image);

	}

}
