package com.example.demo;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@Configuration
public class CustomerMongoConfig extends AbstractReactiveMongoConfiguration {

  @Autowired private CustomerProperties properties;

  @Override
  @Bean
  public MongoClient reactiveMongoClient() {
    return MongoClients.create(properties.getMongoUri());
  }

  @Override
  protected String getDatabaseName() {
    return properties.getDatabase();
  }
}
