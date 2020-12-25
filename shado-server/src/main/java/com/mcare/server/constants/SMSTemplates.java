/**
 * 
 */
package com.mcare.server.constants;

/**
 * @author user
 *
 */
public class SMSTemplates {
	
	public static final String OWNER_REGISTRATION_TEMPLATE = "Dear ##USER_NAME##,\n"+
																"Welcome to MCareApp services, you can book your ride through the app.\n"+
																"Looking forward to serve you better.\n"+ 
																"Regards\n"+
																"--\n@Team MCareApp ";
	
	public static final String OTP_TEMPLATE = "Dear customer,\n"+
			"Here is the OTP for your registration :  ##OTP## \nValid for 10 mins."+
			"\nRegards\n"+
			"--\n@Team MCareApp";
 
	
 

}
