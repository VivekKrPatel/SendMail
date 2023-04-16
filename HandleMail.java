package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class HandleMail {

    void sendAttachment(){

//        host : gmail is smtp
        String host = "smtp.gmail.com";

        Properties props = System.getProperties();
        System.out.println(props);

//        set properties:
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.auth","true");

//        Session
        Session mailSession = Session.getInstance(props,new MailAuthenticator());

//        create the message object
        MimeMessage mimeMessage = new MimeMessage(mailSession);

//        set values in message object
        try {
//            set sender's mail
            mimeMessage.setFrom(MailConstants.SENDER);

//            set receiver's mail
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(MailConstants.RECEIVERMAILADDRESS));

//            set subject of mail
            mimeMessage.setSubject(MailConstants.SUBJECT);

//            set message of mail
            mimeMessage.setText(MailConstants.MESSAGE);

            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
