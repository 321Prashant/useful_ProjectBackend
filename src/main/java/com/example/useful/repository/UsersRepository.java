package com.example.useful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

//	This query needs to be changed accordingly for getting user's OTP thta is not null
	@Query(value="Delete from company where emailId = :userId", nativeQuery =true)
	List<Integer> findAllEmailOfUser(Integer userId);
		
}
