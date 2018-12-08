package com.patryk.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patryk.application.models.Category;
import com.patryk.application.services.CategoryService;

@RestController
public class CategoriesController {

	@Autowired
	private CategoryService categoriesService;

	@GetMapping("/categories")	
	public List<Category> getAllCategories() {
		return categoriesService.getAllCategories();

	}

}
