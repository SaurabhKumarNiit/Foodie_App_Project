package com.foodieapp.paymentGateWay.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public boolean sendEmail(String email,int amount){
        boolean result = false;


        System.out.println(email);

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

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            m.setSubject("Your Order Placed SuccessFully");

            m.setText("Dear customer, your order for ₹ "+ amount+" was received successfully. " +
                    "" +
                    " We appreciate your use of our foodie app. return once more  Thank You............");
            Transport.send(m);
            System.out.println("Sent success...................");
            result=true;

        } catch (Exception e) {

            e.printStackTrace();
        }
        return result;
    }
}
