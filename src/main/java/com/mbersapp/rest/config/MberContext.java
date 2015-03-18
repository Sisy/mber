package com.mbersapp.rest.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

@Configuration
public class MberContext {

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient("localhost", 27017);
    }

    @Bean
    public DB mongoDb() throws UnknownHostException {
        return mongoClient().getDB("mber");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoClient(), "mber");
    }
}
