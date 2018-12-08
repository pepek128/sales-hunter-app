package com.patryk.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.patryk.application.models.Category;
import com.patryk.application.repositories.CategoriesRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoriesRepository categoriesRepository;

	public List<Category> getAllCategories() {

		List<Category> categories = new ArrayList<>();
		categoriesRepository.findAll().forEach(categories::add);
		return categories;
	}

	
}
