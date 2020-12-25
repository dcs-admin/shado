package com.srans.uaa.repository;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srans.uaa.domain.Register;
import com.srans.uaa.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("from Register s where s.mobileNumber=:username ")
	public Optional<Register> findByUserName(@Param("username") Long username);
}
