package com.patryk.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.patryk.application.models.Deal;
@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface DealsRepository extends JpaRepository<Deal, Integer> {

}