package com.mcare.server.repository;

 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mcare.server.model.Register;

@Repository
public interface RegisterRepository extends PagingAndSortingRepository<Register, Long> {

	@Query(value="SELECT t FROM Register t WHERE t.mobileNumber=?1 and t.password=?2") 
	public Register getRegisterByPwd(Long tid, String pwd);
	
	
	@Query(value="SELECT t.email FROM Register t WHERE t.mobileNumber=?1") 
	public String getEmail(Long mobileNumber);
	
	@Query(value="SELECT t FROM Register t WHERE t.mobileNumber=?1 ") 
	public Register findByPhoneNumber(Long mobileNumber);
	
	@Query(value="SELECT * FROM Register r WHERE lower(r.name) like '%'||?1||'%' ", nativeQuery=true) 
	public List<Register> findByWildCardName(String name);
	
	@Query(value="SELECT * FROM Register r WHERE r.mobile_Number like '%'||?1||'%'", nativeQuery=true) 
	public List<Register> findByWildCardMobile(String wildcard);
	
	
	@Query(value="SELECT t.status FROM Register t WHERE t.mobileNumber=?1  ") 
	public Optional<String> getUserStatus(Long mobileNumber );
	
	
	@Query(value="SELECT r FROM Register r WHERE r.role =?1 order by r.updDate desc") 
	public List<Register> getUsers(String role);
	
	@Query(value="SELECT r FROM Register r order by r.updDate desc") 
	public List<Register> getUsersByUpdatedDate();
	
	@Modifying
	@Query("update Register set status=?1, comments=?2 where mobileNumber=?3")
	public void updateStatus(String status, String comments, Long mobileNumber);
	
	
	@Modifying
	@Query("update Register set role=?1 where mobileNumber=?2")
	public void updateUserRole(String role, Long mobileNumber);
	
	@Modifying
	@Query("update Register set lastOnline=now() where mobileNumber=?1")
	public void updateOnlineDate(Long mobileNumber);
	


	public List<Register> findByNameContaining(String lowerCase);
	 
 }
