package com.example.useful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.useful.entity.Roless;

@Repository
public interface RolesRepository extends JpaRepository<Roless, Integer> {

}
