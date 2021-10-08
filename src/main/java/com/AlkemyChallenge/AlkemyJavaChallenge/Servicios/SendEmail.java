package com.AlkemyChallenge.AlkemyJavaChallenge.Servicios;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

/**
 *
 * @author delam
 */
@Service
public class SendEmail {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String correo) throws IOException {
        
        
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("springchallengealkemy@gmail.com");
        message.setTo(correo);
        message.setText("Gracias por su interés en mi trabajo. Espero que lo disfrute y no dude en consultar sobre cualquier cuestión!");
        message.setSubject("Challenge Alkemy");

        mailSender.send(message);    
       
        
            }

   

}

