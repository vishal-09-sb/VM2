package com.moviebookingApp.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.moviebookingApp.model.Movie;

@Component
public class MovieKafkaProducer {

    private static final String TOPIC = "movie-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMovieMessage(String movieMessage) {
        kafkaTemplate.send(TOPIC, movieMessage);
    }
}
