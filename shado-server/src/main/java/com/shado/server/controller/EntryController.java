package com.shado.server.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shado.server.exception.ResourceNotFoundException;
import com.shado.server.model.Entry;
import com.shado.server.repository.EntryRepository; 

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
public class EntryController {
	
	private Logger logger = LoggerFactory.getLogger(EntryController.class);
	
	@Autowired
	private EntryRepository entryRepository; 
	  
	
	
	@GetMapping("/entries/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Entry>> getAllEntries() {
    	
    	List<Entry> entries = (List<Entry>) entryRepository.findAll();
    	return new ResponseEntity<List<Entry>>(entries, new HttpHeaders(), HttpStatus.OK);
    }
	
	
	@PostMapping("/entries")
	@PreAuthorize("authentication.principal == #entry.userId")
	public Entry saveEntry(@RequestBody Entry  entry) {
		
		logger.info("IN::/entries:"+entry);  
		
		entry = entryRepository.save(entry); 
		
		logger.info("Out::/entries:"+entry);
		return entry;
	} 
	
	@PutMapping("/entries")
	@PreAuthorize("authentication.principal == #entry.userId")
	public Entry updateEntry(@RequestBody Entry  entry) {
		
		logger.info("IN::PUT::/entries:"+entry);  
		
		entry = entryRepository.findById(entry.getId()).orElseThrow(() -> new ResourceNotFoundException("Given Entry not found to update")); 
		entry = entryRepository.save(entry); 
		
		logger.info("Out::PUT::/entries:"+entry);
		return entry;
	} 
	
	
	@DeleteMapping("/entries")
	@PreAuthorize("authentication.principal == #entry.userId")
	public Entry deleteEntry(@RequestBody Entry  entry) {
		
		logger.info("IN::DELETE::/entries:"+entry);  
		
		entry = entryRepository.findById(entry.getId()).orElseThrow(() -> new ResourceNotFoundException("Given Entry not found to delete")); 
	    entryRepository.delete(entry);
		
		logger.info("Out::DELETE::/entries:");
		return entry;
	} 
	
	
	@DeleteMapping("/entries/byuser/{userId}")
	@PreAuthorize("authentication.principal == #userId")
	@Transactional
	public ResponseEntity<String> deleteEntriesByUserId( @PathVariable("userId") Long userId) {
		
		logger.info("IN::DELETAE::/entries/byuser/{userId}:"+userId);  
		
		entryRepository.deleteAll(userId); 
		
		logger.info("Out::DELETE::/entries/byuser/{userId}:");
		return new ResponseEntity<String>("DONE", new HttpHeaders(), HttpStatus.OK);
	} 
	
	
	 
	@GetMapping("/entries/byuser/{userId}")
	@PreAuthorize("authentication.principal == #userId")
	public List<Entry> getEntriesByUserId(
			@PathVariable("userId") Long userId,
			@RequestParam("year:0") int year ,
			@RequestParam("month:0") int month
			
	) {
		
		logger.info("In::/entries/byuser/{userId}"+userId+"y"+year+";m"+month);  
		
		List<Entry> entries = null;
		
		try {
			if(month == 0 || year == 0){ 
				entries = entryRepository.findByUserId(userId);
			}else{
				entries = entryRepository.findByUserIdWithMonthYearFilter(userId, month, year); 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("Out::/entries/byuser/{userId}::"+entries);
		return entries;
	} 
	 
	 
	

}
