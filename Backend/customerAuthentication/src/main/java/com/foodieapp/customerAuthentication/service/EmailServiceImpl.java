package com.foodieapp.customerAuthentication.service;

import com.foodieapp.customerAuthentication.domain.Customer;
import org.springframework.stereotype.Service;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{

    @Override
    public boolean sendEmail(Customer customer){
        boolean result = false;
        String from = "foodie.app.main@gmail.com";
        //Variable For Gmail
        String host="smtp.gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("foodie.app.main@gmail.com", "ssxezsjrzmkuxukq");
            }
        });

        session.setDebug(true);

        //Step 2 : compose the message [text]
        MimeMessage m = new MimeMessage(session);

        try {

            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(customer.getEmail()));

            m.setSubject("Register");

            m.setText("You are Successfully Register in Foodie-App Now you can Login");
            Transport.send(m);
            System.out.println("Sent success...................");
            result=true;

            } catch (Exception e) {

                e.printStackTrace();
            }
        return result;
    }

    @Override
    public boolean sendEmailInCustomerLogin(Customer customer) {
        boolean result = false;
        String from = "foodie.app.main@gmail.com";
        //Variable For Gmail
        String host="smtp.gmail.com";
        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step 1: to get the session object..
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("foodie.app.main@gmail.com", "ssxezsjrzmkuxukq");
            }
        });

        session.setDebug(true);

        //Step 2 : compose the message [text]
        MimeMessage m = new MimeMessage(session);

        try {
            //from email
            m.setFrom(from);
            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(customer.getEmail()));
            //adding subject to message
            m.setSubject("Login");
            m.setText("You have Successfully Logged in Foodie-App Now you can Place Order.....");
            //Step 3 : send the message using Transport class
            Transport.send(m);
            System.out.println("Sent success...................");
            result=true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}