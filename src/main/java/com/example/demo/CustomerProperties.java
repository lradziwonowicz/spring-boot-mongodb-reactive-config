package com.example.demo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CustomerProperties {

  @Value("${mongo.uri}")
  private String mongoUri;

  @Value("${mongo.database}")
  private String database;

  public String getMongoUri() {
    return mongoUri;
  }

  public String getDatabase() {
    return database;
  }
}
