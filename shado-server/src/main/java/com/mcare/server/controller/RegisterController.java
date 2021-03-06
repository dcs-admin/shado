package com.mcare.server.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcare.server.constants.ServerConstants;
import com.mcare.server.model.ChangePasswd;
import com.mcare.server.model.Register;
import com.mcare.server.repository.RegisterRepository;
import com.mcare.server.service.RegisterService;
import com.mcare.server.util.SecurityCheck;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RestController
public class RegisterController {

	private Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private RegisterService registerService;

	@SuppressWarnings("unused")
	@Autowired
	private SecurityCheck securityCheck;

	@GetMapping("/registers")
	@PreAuthorize("authentication.principal == 'admin'")
	public ResponseEntity<List<Register>> getUsers() {

		List<Register> users = (List<Register>) registerRepository.findAll();
		return new ResponseEntity<List<Register>>(users, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/register")
	@PreAuthorize("permitAll()")
	public Register saveRegister(@RequestBody Register register) {

		logger.info("IN::/register:" + register);
		register.setStatus("N");// Not Accedpted State
		register = this.registerService.doRegister(register);

		register = registerRepository.save(register);

		logger.info("Out::/register:" + register);
		return register;
	}

	@PostMapping("/register/otp")
	@PreAuthorize("permitAll()")
	public Register sendOTP(@RequestBody Register register) throws Exception {

		logger.info("IN::/register/otp/" + register);

		Optional<String> isRecordExists = registerRepository.getUserStatus(register.getMobileNumber());
		if (isRecordExists.isPresent()) {

			if (!isRecordExists.get().equals("I")) {
				throw new Exception("This mobileNumber already registered, please choose diffrent one.");
			}
		}
		register = this.registerService.sendOTP(register);
		register.setStatus("I");// Inactive
		register = registerRepository.save(register);

		logger.info("Out:::/register/otp/:" + register.getOtp());
		return register;
	}

	@PostMapping("/register/online/{id}")
	@Transactional
	@PreAuthorize("@securityCheck.check(#id, authentication)")
	public void saveOnlineDate(@PathVariable Long id) {
		logger.info("In::/register/online/{id}" + id);
		registerRepository.updateOnlineDate(id);
		logger.info("Out::/register/online/{id}" + id);

	}

	@PostMapping("/register/changepassword")
	@PreAuthorize("@securityCheck.check(#userId, authentication)")
	public String changePassword(@RequestBody ChangePasswd changePasswd) throws Exception {

		logger.info("In::" + changePasswd);

		Register register = registerRepository.findByPhoneNumber(changePasswd.getUserId());
		if (register != null) {

			if (!register.getPassword().equals(changePasswd.getCurrPassword())) {
				throw new Exception("Current Password not matched");
			}
			register.setPassword(changePasswd.getPassword());
			registerRepository.save(register);
		}

		return "success";
	}

	@GetMapping("/register/{ownerId}")
	// @PreAuthorize("permitAll()")
	// @PreAuthorize("authentication.principal.equals(#ownerId)")
	@PreAuthorize("@securityCheck.check(#ownerId, authentication)")
	public Register getRegister(@PathVariable("ownerId") Long ownerId, Authentication authentication) {

		logger.info("In::/register/{mobileNumber}" + ownerId);

		Register register = registerRepository.findByPhoneNumber(ownerId);

		logger.info("Out::" + register);
		return register;
	}

	@GetMapping("/register/byrole/{role}")
	@PreAuthorize("@securityCheck.check(#ownerId, authentication)")
	public Register getRegisterWithOptions(@PathVariable("role") String role, @RequestParam("ownerId") Long ownerId,
			@RequestParam("supervisorId") Long supervisorId) {

		logger.info("In::/register/{role}" + role + ";o" + ownerId + ";s" + supervisorId);

		Register register = null;
		if (role.equals(ServerConstants.OWNER_CODE)) {

			register = registerRepository.findByPhoneNumber(ownerId);

		}

		logger.info("Out::" + register);
		return register;
	}

}
