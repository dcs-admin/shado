/**
 * 
 */
package com.mcare.server.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mcare.server.communication.MCareMailer;
import com.mcare.server.communication.MCareSmsGateway;
import com.mcare.server.constants.SMSTemplates;
import com.mcare.server.model.Register;

import freemarker.template.TemplateException;

/**
 * @author user
 *
 */
@Service
public class RegisterService {

	private static Logger logger = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	private MCareSmsGateway mCareSmsGateway;
	
	@Autowired
	private MCareMailer mCareMailer;

	private Map<String, Object> reqParamtersMap;

	@Autowired
	private TemplateEngine templateEngine; 
	
	//@Autowired
	//private PasswordGenerator passwordGenerator;
	
	@Autowired
	private CustomerCareService customerCareService;
	
	private Random rand = new Random(); 
	
	
	
	public Register doRegister(Register register){
		
		 //register.setPassword(passwordGenerator.generateRamdomPassword());
		 this.triggerAlertEmail(register);
		 
		 this.triggerSMS(register);
		 
		 return register; 
		
	}
	
	
	public Register sendOTP(Register register){
		 
		 
		logger.debug("In::sendOTP"+register);
		String otp = ""+getNum()+""+getNum()+""+getNum()+""+getNum();
		register.setOtp(otp);

		try {
			String message = "";  
			message = SMSTemplates.OTP_TEMPLATE .replaceAll("##OTP##", otp); 
			mCareSmsGateway.sendSMS(register.getMobileNumber()+"", message);  
			logger.debug("Out::triggerAlertSMS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			String email, subject, ccMail, bccMail, message = null;
			email = register.getEmail();
			 
			subject = "Your OTP for User Registration";
			ccMail = null;
			bccMail = null; 
						 
			message = this.getTemplate("otp-template", register);

			 
			mCareMailer.sendEmail(email, subject, ccMail, bccMail, message);

			logger.debug("EMIAL SENT ");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("In::sendOTP"+e.getMessage());
		} 

		
		logger.debug("In::sendOTP"+otp);
		return register;
		
		
	} 
	
	
	private int getNum(){
		
		int num = rand.nextInt(9);
		if(num <= 0){
			num *= -1;
		}
		return num;
	}
	
	
	
	

	/**
	 * 
	 * @param templateFileName Name of the template file without extension
	 * @param text
	 * @return
	 */ 
	public String getTemplate(String templateFileName , Register register) {
		logger.trace("In::");
		reqParamtersMap = new HashMap<>();

//		if(user.getRole().endsWith(NSConstants.ROLE_TENANT)&& user.getStatus().equals("A")) {
//		reqParamtersMap.put("password", user.getUserSubscriptionWrapper().getUser().getPassword());
//		reqParamtersMap.put("name", user.getName());
// 
//		reqParamtersMap.put("hostel_name", (hostelRepo.getOne(user.getTenantBooking().getHostelId())).getHostelName());
//		reqParamtersMap.put("floor_number", user.getTenantBooking().getFloorId());
//		reqParamtersMap.put("room_number", user.getTenantBooking().getRoomId());
//		reqParamtersMap.put("room_rent", user.getTenantBooking().getRoomRent());	
//		reqParamtersMap.put("bed", user.getTenantBooking().getRoomBedId());
//		}
//		
//		else if(user.getRole().endsWith(NSConstants.ROLE_TENANT) && user.getStatus().equals("NA")) {
//			
//			reqParamtersMap.put("name", user.getName());
//			
//		}
//		else if(user.getRole().endsWith(NSConstants.ROLE_GUEST)) {
//			reqParamtersMap.put("name", user.getName());
//
//			reqParamtersMap.put("password", user.getUserSubscriptionWrapper().getUser().getPassword());
//
//		}
// 
//		
//		else if(user.getRole().endsWith(NSConstants.ROLE_ADMIN)) {
//			reqParamtersMap.put("password", user.getUserSubscriptionWrapper().getUser().getPassword());
//			reqParamtersMap.put("name", user.getName());
//			reqParamtersMap.put("subscription", user.getSubscriptions());
//		}
		 
		
		reqParamtersMap.put("id", register.getMobileNumber());
		//reqParamtersMap.put("date", register.getInstallationDate());
 		reqParamtersMap.put("mobileNumber",register.getMobileNumber());
 		//reqParamtersMap.put("validity",register.getMonths());
 		//reqParamtersMap.put("installationDate", register.getInstallationDate());
 		reqParamtersMap.put("email", register.getEmail()); 
 		//reqParamtersMap.put("AppVersion", register.getAppVersion()); 
 		//reqParamtersMap.put("LicenceUpTo", register.getLicenceUpTo()); 
 		reqParamtersMap.put("name", register.getName()); 
 		reqParamtersMap.put("otp", register.getOtp()); 
 		reqParamtersMap.put("today_date", ""+new Date());
 		reqParamtersMap.put("password", register.getPassword());
 		
 		reqParamtersMap.put("status", register.getStatus().equals("N")?"Rejected" : "Accepted" );
 		reqParamtersMap.put("comments", register.getComments());
 		
 		reqParamtersMap.put("customercare", customerCareService.getCustomerCareNumbers());

 		
 		
		String output = this.templateEngine.process(templateFileName,
				new Context(Locale.getDefault(), reqParamtersMap));

		reqParamtersMap = null;

		logger.trace("Out::");
		return output;
	}

	

	 
	
	/**
	 * 
	 * @param templateFileName Name of the template file without extension
	 * @param text
	 * @return
	 */ 
	public String getTemplate(String templateFileName, Long phoneNumber, String name, String email, String password) {
		logger.trace("In::");
		reqParamtersMap = new HashMap<>();
  
 		reqParamtersMap.put("mobileNumber", phoneNumber); 
 		reqParamtersMap.put("email",  email);  
 		reqParamtersMap.put("name", name);  
 		reqParamtersMap.put("password", password);
 		reqParamtersMap.put("today_date", ""+new Date());
 		reqParamtersMap.put("customercare", customerCareService.getCustomerCareNumbers());
 		
 		
		String output = this.templateEngine.process(templateFileName,
				new Context(Locale.getDefault(), reqParamtersMap));

		reqParamtersMap = null;

		logger.trace("Out::");
		return output;
	}

	public boolean triggerAlertEmail( Register register) {

		boolean emailStatus = false;

		try {

			logger.debug("In::triggerAlertEmail");

			String email, subject, ccMail, bccMail, message = null;
			email = register.getEmail();
			 
			subject = "Dear "+register.getName()+", Your Registration Confirmation";
			ccMail = null;
			bccMail = null; 
						 
			message = this.getTemplate("registration-info", register);

			 
			mCareMailer.sendEmail(email, subject, ccMail, bccMail, message);
 
			emailStatus = true;

			logger.debug("Out::triggerAlertEmail");

		} catch (MailException e) {
			logger.error("Exception: "+e.getMessage());
		} catch (MessagingException e) {
			logger.error("Exception: "+e.getMessage());
		} catch (IOException e) {
			logger.error("Exception: "+e.getMessage());
		} catch (TemplateException e) {
			logger.error("Exception: "+e.getMessage());
		}

		return emailStatus;

	}
	
	
	public boolean triggerForgotPasswordEmail(Long phoneNumber, String name, String email, String password) {

		boolean emailStatus = false;

		try {

			logger.debug("In::triggerForgotPasswordEmail");

			String  subject, ccMail, bccMail, message = null;
			//email = register.getEmail();
			 
			subject = "Forget password help";
			ccMail = null;
			bccMail = null; 
						 
			message = this.getTemplate("forget-password-help", phoneNumber, name,  email,  password);

			 
			mCareMailer.sendEmail(email, subject, ccMail, bccMail, message);

			logger.debug("EMIAL SENT ----------------------------------");
			emailStatus = true;

			logger.debug("Out::triggerAlertEmail");

		} catch (MailException e) {
			logger.error("Exception: "+e.getMessage());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Out:: "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Out:: "+e.getMessage());
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Out:: "+e.getMessage());
		}

		return emailStatus;

	}


	public boolean triggerSMS( Register register) {

		logger.debug("In::triggerSMS");
		boolean smsStatus = false;

		try {
			String message = ""; 
			 
			message = SMSTemplates.OWNER_REGISTRATION_TEMPLATE 
					.replaceAll("##USER_NAME##", register.getName());

			mCareSmsGateway.sendSMS("" + register.getMobileNumber(), message);

			smsStatus = true;

			logger.debug("Out::triggerAlertSMS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Out:: "+e.getMessage());
		}

		return smsStatus;

	}

}
