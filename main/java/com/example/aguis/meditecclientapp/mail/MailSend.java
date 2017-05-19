package com.example.aguis.meditecclientapp.mail;

import android.os.StrictMode;

import com.facebook.Profile;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * Created by aguis on 19/5/2017.
 */

public class MailSend {

    private String email;
    private String password;
    private String messageToSend = "";

    private  Session session;

    private Profile profile;

    public MailSend(String email, String password) {
        this.email = email;
        this.password = password;

        profile = Profile.getCurrentProfile();

        messageToSend += "Hola: " + profile.getFirstName() + "te damos la bienvenida al servicio MediTEC.";
        messageToSend += "\n" + "Para poder utilizar este servicio al máximo, te invitamos a accesar el siguiente link: ";
        messageToSend += "\n" + ("https://1drv.ms/i/s!AlXquVJ9Th-XhzoLhHkKEiTgEgqV");
    }

    public void sendMail(String mailReceptor) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        try {

            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, password);
                }
            });

            if (session != null) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));
                message.setSubject("Confirmación ClientApp MediTEC");
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailReceptor));
                message.setContent(messageToSend, "text/html; charset=utf-8");

                Transport.send(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
