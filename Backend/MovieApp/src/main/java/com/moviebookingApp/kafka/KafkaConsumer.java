//package com.moviebookingApp.kafka;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import com.moviebookingApp.model.UserDTO;
//
//@Service
//public class KafkaConsumer {
//	
//	@KafkaListener(topics = "userLoggedTopic", groupId = "group_id")
//	public void consume(UserDTO user) {
//		System.out.println("user logged in: "+ user.getUserName());
//	}
//
//}
