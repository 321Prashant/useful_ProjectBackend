package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.useful.entity.BankBranchDetails;

public interface BankDetailsRepository extends JpaRepository<BankBranchDetails,Long> {

}
