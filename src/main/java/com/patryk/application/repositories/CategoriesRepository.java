package com.patryk.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.patryk.application.models.Category;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

	  Category findBycategoryID (Integer id) ;
	  

}