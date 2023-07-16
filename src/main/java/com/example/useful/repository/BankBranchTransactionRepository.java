package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.BankBranchTransaction;

@Repository 
public interface BankBranchTransactionRepository extends JpaRepository<BankBranchTransaction, Integer> {

}
