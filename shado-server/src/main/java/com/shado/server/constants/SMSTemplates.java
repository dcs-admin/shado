/**
 * 
 */
package com.shado.server.constants;

/**
 * @author user
 *
 */
public class SMSTemplates {
	
	public static final String OWNER_REGISTRATION_TEMPLATE = "Dear ##USER_NAME##,\n"+
																"Welcome to VCars services, you can book your ride through the app.\n"+
																"Looking forward to serve you better.\n"+ 
																"Regards\n"+
																"--\n@Team VCars ";
	
	public static final String OTP_TEMPLATE = "Dear customer,\n"+
			"Here is the OTP for your registration :  ##OTP## \nValid for 10 mins."+
			"\nRegards\n"+
			"--\n@Team VCars";
	
	public static final String ACCEPTANCE_TEMPLATE = "Dear customer,\n"+
			"Your profile status updated to  ##STATUS## "+
			"\nRegards\n"+
			"--\n@Team VCars";
	
	public static final String USER_TO_OWNER_TEMPLATE = "Dear customer,\n"+
			"Your car ##CARNUMBER### added to VCars. You can check details from your app."+
			"\nRegards\n"+
			"--\n@Team VCars";
	
	public static final String TENANT_ONBOARDING_TEMPLATE = "Hello ##USER_NAME##, \n"+
			"Welcome to ##HOSTEL_NAME##.\n"+
			"Here is your booking details\n"+
			"Floor Num : ##FLOOR##\n"+
			"Room Num : ##ROOM##\n"+
			"Bed Num : ##BED##\n"+
			"Monthly Rent : ##RENT##\n"+
			"Advance Paid : ##ADVANCE##\n"+
			"Download app from appstore http://shorturl.at/yN028/##num## and login with temp password : ##PASSWORD##\n"+
			"Regards\n"+
			"--\n@Team VCars";
	
	public static final String SUPERVISOR_ONBOARDING_TEMPLATE = "Hello ##USER_NAME##, \n"+
			"You are requested as supervisory operations with the request from  ##OWNER##.\n"+  
			"Download app from appstore and login with temp password : ##PASSWORD##\n"+
			"Regards\n"+
			"--\n@Team VCars";
	
	public static final String BOOKING_TEMPLATE = "Dear ##USER_NAME##,\n"+
			"You booking successfull.\nModel:##CAR_BRAND##,\nBookingID: ##ID##"+ 
			"\nFrom:##RIDE_FROM## \nTo: ##RIDE_TO##.\n"+ 
			"\nLocation:  ##PICKUP##.\n"+ 
			"Amount Paid : ##AMOUNT_PAID##\n"+ 
			"Please bring your original Aadhar for verification.\n"+ 
			"Regards\n"+
			"--\n@Team VCars"; 
	
	public static final String BOOKING_CANCEL_TEMPLATE = "Dear ##USER_NAME##, \n"+
			"your ride cancelled by ##WHOM## with : ##CAR_BRAND##,\nID: ##ID##"+ 
			"\nRide from  ##RIDE_FROM## to ##RIDE_TO##.\n"+ 
			"\nComments:  ##COMMENTS##.\n"+ 
			"Refund will be credited within 7 working days.\n"+ 
			"Regards\n"+
			"--\n@Team VCars"; 
	
	public static final String BOOKING_EXTENTION_TEMPLATE = "Dear ##USER_NAME##, \n"+
			"your ride extended from ##RIDE_OLD_TODATE## to ##RIDE_TO##,\nID: ##ID##"+  
			"\nComments:  ##COMMENTS##.\n"+ 
			"Regards\n"+
			"--\n@Team VCars"; 
	
	
	
	public static final String TENANT_VACATION_TEMPLATE = "Dear ##USER_NAME##, \n"+ 
			"As requested ypu are successfully vacated from your current PG.\n"+ 
			"Hope you enjoy seemless services and re-visit us again.\n"+
			"Download app from appstore \n"+
			"Regards\n"+
			"--\n@Team VCars";
	
	
	
 

}
