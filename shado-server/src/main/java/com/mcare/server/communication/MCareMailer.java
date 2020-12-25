package com.mcare.server.communication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import freemarker.template.TemplateException;

/**
 * 
 * @author Manish
 *
 */

@Service 
public class MCareMailer {

	@Autowired
	private JavaMailSender javaMailSender; 
	
	@Value("${vcars.admin.mail:technical.ipg@gmail.com}")
	private String ADMIN_MAIL;
	 

	public void sendEmail(String email, String subject, String ccMail, String bccMail, String message ) throws MailException, MessagingException, IOException, TemplateException {
    
		MimeMessage mimeMessage = javaMailSender.createMimeMessage(); 
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

	    //helper.addAttachment("srans.jpg", new ClassPathResource("srans.jpg"));
		helper.setTo(email);  
		helper.setText( message, true); 
		//helper.setReplyTo("technical.ipg@gmail.com");
		helper.setReplyTo("technical.ipg@gmail.com");
		helper.setFrom("technical.ipg@gmail.com", "MCare"); 
		helper.setSubject(subject);
		//if(ccMail != null) helper.addCc(ccMail);
		//if(bccMail != null) helper.addBcc(bccMail);
		//TODO Need to remove this block and address from caller point of view
		if(!subject.contains("OTP")){
			helper.addCc(ADMIN_MAIL);
			helper.addBcc("technical.ipg@gmail.com"); 
		}

		//Now trigger an email with above details	
		if(email != null){
			javaMailSender.send(mimeMessage);
		}

	}

}
