package com.mcare.server.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcare.server.model.CustomerCare;

@Repository
public interface CustomerCareRepository extends JpaRepository<CustomerCare, Long> {
  
 }
