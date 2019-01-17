package com.patryk.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patryk.application.models.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

	  Category findBycategoryID (Integer id) ;
	  

}