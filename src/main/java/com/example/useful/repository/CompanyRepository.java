package com.example.useful.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.Company;
import com.example.useful.entity.Users;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	

//	@Transactional
//	@Modifying
//	@Query(value = "Delete from company where company_id = ?1", nativeQuery = true)
//	 public void deleteCompanyId(Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "Delete from company where company_id = :id", nativeQuery = true)
	 public void deleteCompanyId(@Param("id") Integer id);

	@Query(value = "Select * from user where user_id = (select * from company where company_id = :id)", nativeQuery = true)
	public Users findUserFromCompany(Integer id);
	
}
