package com.savvycom.userservice.service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        final String username = "thangthontien2k@gmail.com";
        final String password = "ecsy rwse ufny vbtc\n";  // Use the generated app password here
        final String recipientEmail = "thangshine2k@gmail.com";  // Replace with the actual recipient email

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        try {
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);

            // Set recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set other message details, such as subject, body, etc.
            message.setSubject("Test Subject");
            message.setText("This is a test email.");

            // Send the message
            try (Transport transport = session.getTransport("smtp")) {
                transport.connect(username, password);
                transport.sendMessage(message, message.getAllRecipients());
            }

            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
