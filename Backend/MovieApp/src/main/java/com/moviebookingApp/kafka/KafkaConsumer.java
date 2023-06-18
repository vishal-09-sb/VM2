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
//	public void consume(String userName) {
//		System.out.println("user logged movie: "+userName);
//	}
//
//}
