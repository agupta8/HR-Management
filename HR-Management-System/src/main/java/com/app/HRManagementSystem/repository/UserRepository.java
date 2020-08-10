package com.app.HRManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HRManagementSystem.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(String userId);
}
