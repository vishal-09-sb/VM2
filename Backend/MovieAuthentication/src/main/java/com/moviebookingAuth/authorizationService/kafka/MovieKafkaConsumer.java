package com.moviebookingAuth.authorizationService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MovieKafkaConsumer {

    @KafkaListener(topics = "movie-topic", groupId = "authorization-group")
    public void receiveMovieMessage(String movieMessage) {
        System.out.println("New Movie Added :" +movieMessage);
    }
}