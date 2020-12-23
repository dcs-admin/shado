package com.shado.server.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shado.server.model.CustomerCare;

@Repository
public interface CustomerCareRepository extends JpaRepository<CustomerCare, Long> {
  
 }
