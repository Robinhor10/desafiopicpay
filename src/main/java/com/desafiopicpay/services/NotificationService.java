package com.desafiopicpay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafiopicpay.domain.user.User;
import com.desafiopicpay.dtos.NotificationDto;

@Service
public class NotificationService {
    
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDto notificationRequest = new NotificationDto(email, message);

      ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
    
      if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
        System.out.println("erro ao enviar notificacao");
        throw new Exception("Servico de notificacao indisponivel");
      }  

    }
}
