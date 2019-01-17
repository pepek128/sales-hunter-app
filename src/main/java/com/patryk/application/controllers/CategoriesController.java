package com.patryk.application.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patryk.application.dto.CategoryDTO;
import com.patryk.application.dto.DealDTO;
import com.patryk.application.models.Category;
import com.patryk.application.services.CategoryService;

@RestController
public class CategoriesController {
	private static final ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private CategoryService categoriesService;

	@GetMapping("/categories")
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoriesService.getAllCategories();
		List<CategoryDTO> categoriesDTO = new ArrayList<>();

		for (Category x : categories) {

			categoriesDTO.add(modelMapper.map(x, CategoryDTO.class));

		}
		return categoriesDTO;
	}
}
