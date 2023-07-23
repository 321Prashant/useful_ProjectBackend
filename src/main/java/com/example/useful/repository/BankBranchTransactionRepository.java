package com.example.useful.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.BankBranchTransaction;
import com.example.useful.entity.EmpBankDetails;



@Repository 
public interface BankBranchTransactionRepository extends JpaRepository<BankBranchTransaction, Long> {
	
	@Query( value = "select * from bank_branch_transaction where emp_bank_details_id =:id order by transaction_date desc", nativeQuery = true)
	List<BankBranchTransaction> getByEmpBankDetails(Long id);
	
}
//List<type> findBy()
