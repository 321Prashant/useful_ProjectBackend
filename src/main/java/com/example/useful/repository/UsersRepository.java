package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
		
}
