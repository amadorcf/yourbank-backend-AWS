package es.amadorcf.YourBank_backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailServiceImpl implements EmailService{

	   private final JavaMailSender mailSender;

	    @Autowired
	    public EmailServiceImpl(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	    }

	    @Override
	    @Async
	    public CompletableFuture<Void> sendEmail(String to, String subject, String text) {
	        CompletableFuture<Void> future = new CompletableFuture<>();

	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            // No need to set the "from" address; it is automatically set by Spring Boot based on your properties
	            helper.setSubject(subject);
	            helper.setText(text, true); // Set the second parameter to true to send HTML content
	            mailSender.send(message);

	            future.complete(null); // Indicate that the email sending is successful
	        } catch (MessagingException e) {
	            e.printStackTrace();
	            future.completeExceptionally(e); // Indicate that the email sending failed
	        }

	        return future;
	    }
	    
	    public String getOtpLoginEmailTemplate(String name, String accountNumber, String otp) {

	    	return "<div style=\"font-family: Helvetica, Arial, sans-serif; min-width: 320px; max-width: 1000px; margin: 0 auto; overflow: auto; line-height: 2; background-color: #f1f1f1; padding: 20px;\">" +
	                "<div style=\"margin: 50px auto; width: 100%; max-width: 600px; padding: 20px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);\">" +
	                "<div style=\"border-bottom: 1px solid #ddd; padding-bottom: 10px; text-align: center;\">" +
	                "<a href=\"https://onestopbank.netlify.app/\" style=\"text-decoration: none;\">" +
	                "<img src=\"https://onestopbank.netlify.app/assets/onestoplogo.jpg\" alt=\"OneStopBank\" style=\"height: 50px; margin-bottom: 10px;\">" +
	                "</a>" +
	                "<h1 style=\"font-size: 1.8em; color: #3f51b5; margin: 10px 0;\">OneStopBank</h1>" +
	                "</div>" +
	                "<div style=\"padding: 20px;\">" +
	                "<p style=\"font-size: 1.2em; color: #333;\">Hi, " + name + ",</p>" +
	                "<p style=\"font-size: 1em; color: #555;\">Account Number: <strong style=\"color: #3f51b5;\">" + accountNumber + "</strong></p>" +
	                "<p style=\"font-size: 1em; color: #333;\">Thank you for choosing OneStopBank. Use the following OTP to complete your login procedures. The OTP is valid for 5 minutes:</p>" +
	                "<h2 style=\"background: #3f51b5; margin: 20px 0; width: max-content; padding: 10px 20px; color: #fff; border-radius: 4px;\">" + otp + "</h2>" +
	                "<p style=\"font-size: 1em; color: #555;\">Regards,<br />The OneStopBank Team</p>" +
	                "</div>" +
	                "<hr style=\"border: none; border-top: 1px solid #ddd; margin: 20px 0;\" />" +
	                "<div style=\"text-align: center; font-size: 0.9em; color: #888;\">" +
	                "<p>Need help? Contact our support team:</p>" +
	                "<p>Email: <a href=\"mailto:onestopbank@google.com\" style=\"color: #3f51b5; text-decoration: none;\">onestopbank@google.com</a></p>" +
	                "<div style=\"margin-top: 20px;\">" +
	                "<p style=\"font-size: 1em; color: #333;\">Show your support here ❤️</p>" +
	                "<a href=\"https://github.com/abhi9720/BankingPortal-API\" style=\"margin: 0 10px; color: #3f51b5; text-decoration: none;\">GitHub</a>" +
	                "</div>" +
	                "</div>" +
	                "</div>" +
	                "</div>";
	    }
	    
	    public void sendEmailWithAttachment(String to, String subject, String text, String attachmentFilePath) {
	        try {
	            MimeMessage message = mailSender.createMimeMessage();
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            helper.setTo(to);
	            helper.setSubject(subject);
	            helper.setText(text, true); // Set the second parameter to true to send HTML content

	            // Add an attachment to the email
	            File attachmentFile = new File(attachmentFilePath);
	            helper.addAttachment(attachmentFile.getName(), attachmentFile);

	            mailSender.send(message);
	        } catch (MessagingException  e) {
	            e.printStackTrace();
	        }
	    }

}
