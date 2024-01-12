 package com.tunehub.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.main.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
public Users findByEmail(String email);
}
