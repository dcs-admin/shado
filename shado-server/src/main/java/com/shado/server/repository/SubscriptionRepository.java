package com.shado.server.repository;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shado.server.model.Subscription;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
	
	@Query("from Subscription s where s.userName=:userName ")
	public Optional<Subscription> findByUserName(@Param("userName") String userName);
}
