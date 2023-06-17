//package com.moviebookingAuth.authorizationService.kafka;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import com.moviebookingAuth.authorizationService.model.UserDTO;
//
//@Service
//public class KafkaProducer {
//	
//	@Autowired
//	private KafkaTemplate<String, UserDTO> kafkaTemplate;
//	
//	@Value("${kafka.topic.userLoggedIn")
//	private String topic;
//	
//	public void sendUserLoggedInEvent(UserDTO userDTO ) {
//		kafkaTemplate.send(topic, userDTO);
//	}
//
//}
