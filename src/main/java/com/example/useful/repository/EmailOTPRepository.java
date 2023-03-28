package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.EmailOTP;

//Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted.

@Repository
public interface EmailOTPRepository extends JpaRepository<EmailOTP, Integer> {

	@Query(value = "Delete from company where emailId = :emailIds", nativeQuery = true)
	String findEmailWithNotNullOtp(Integer emailIds);
	
	@Query(value = "Delete from company where emailId = :emailIds", nativeQuery = true)
	long findByDate(Integer emailIds);

	
}
