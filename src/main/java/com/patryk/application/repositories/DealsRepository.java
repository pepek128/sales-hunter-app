package com.patryk.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patryk.application.models.Category;
import com.patryk.application.models.Deal;

@Repository
public interface DealsRepository extends JpaRepository<Deal, Integer> {

	List<Deal> findByDescriptionContainingIgnoreCase(String text);
	List<Deal> findByNameContainingIgnoreCase(String name);
	List<Deal> findByCategory(Optional<Category> category);
	
}