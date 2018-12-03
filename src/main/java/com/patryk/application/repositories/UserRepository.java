package com.patryk.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patryk.application.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}