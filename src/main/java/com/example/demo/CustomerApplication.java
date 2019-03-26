package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(
    exclude = {MongoAutoConfiguration.class, MongoReactiveDataAutoConfiguration.class})
@Slf4j
public class CustomerApplication implements CommandLineRunner {

  @Autowired public CustomerRepository itemRepository;

  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class, args);
  }

  @Override
  public void run(String... args) {
    this.itemRepository.deleteAll().block();

    // save a couple of customers
    this.itemRepository
        .save(Customer.builder().firstName("Alice").lastName("Smith").build())
        .block();
    this.itemRepository.save(Customer.builder().firstName("Bob").lastName("Smith").build()).block();

    // fetch all customers
    this.itemRepository
        .findAll()
        .subscribe(customer -> log.info("findAll(): {}", customer.toString()));

    // fetch an individual customer
    this.itemRepository
        .findByFirstName("Alice")
        .subscribe(customer -> log.info("findByFirstName('Alice'): {}", customer.toString()));

    this.itemRepository
        .findByLastName("Smith")
        .subscribe(customer -> log.info("findByLastName('Smith'): {}", customer.toString()));
  }
}
