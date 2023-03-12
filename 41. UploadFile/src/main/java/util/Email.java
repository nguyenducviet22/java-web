package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//email: ndv6060@gmail.com
	//password: rezlqbrcynsgmfjr
	
	static final String from = "ndv6060@gmail.com";
	static final String password = "rezlqbrcynsgmfjr";
	static final String to = "nguyenducviet22022004@gmail.com";
	
	public static boolean sendEmail(String to, String subject, String content) {
		//properties
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");//TLS 587, SSL 465
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				
				//create Authenticator
				Authenticator auth = new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from, password);
					}
				};
				
				//work session
				Session session = Session.getInstance(props, auth);
				
				//make an email
				MimeMessage msg = new MimeMessage(session);
				try {
					//type of content
					msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
					//sender
					msg.setFrom(from);
					//recipient
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
					//subject
					msg.setSubject(subject);
					msg.setSentDate(new Date());
					
					msg.setContent(content, "text/html");
					//send email
					Transport.send(msg);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
	}
	
	public static void main(String[] args) {
		Email.sendEmail("nguyenducviet22022004@gmail.com","new email", "This is the content");
		
	}
}
