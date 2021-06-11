package com.example.hruser.reposiroties;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
