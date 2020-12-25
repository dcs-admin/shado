package com.mcare.server.repository;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcare.server.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

	public List<Entry> findByUserId(Long userId); 
	
	@Query(value="SELECT e FROM Entry e WHERE e.userId=?1 and MONTH(e.updDate)=?2 and YEAR(e.updDate)=?3") 
	public List<Entry> findByUserIdWithMonthYearFilter(Long userId,  int month, int year );
	
	@Query(value="DELETE FROM Entry e WHERE e.userId=?1 ") 
	public void deleteAll(Long userId);
  
 }
