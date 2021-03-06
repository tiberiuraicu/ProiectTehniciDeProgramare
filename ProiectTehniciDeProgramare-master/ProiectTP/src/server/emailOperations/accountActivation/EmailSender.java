package server.emailOperations.accountActivation;

import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import database.main.DatabaseOperations;
import objects.entities.Client;


public class EmailSender {
	DatabaseOperations db = new DatabaseOperations();

	public EmailSender(String email) {
		String randomToken = randomTokenGenerator();
		final String username = "ceva.ceva19961996@gmail.com";
		final String password = "ceva.ceva19961996";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			setDisable(randomToken, email);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ceva.ceva19961996@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Testing Subject");
			message.setText(
					"Dear Mail Crawler," + "http://webapp-171203184007.azurewebsites.net/email/" + randomToken);
			Transport.send(message);
			

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void setDisable(String token, String email) {
		Client client = db.getClientByEmail(email);
		client.setToken(token);
		client.setEnabled("false");
		db.updateClient(client);
	}

	public String randomTokenGenerator() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[50];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
}