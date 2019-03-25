package com.example.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

  Flux<Customer> findByFirstName(String first);

  Flux<Customer> findByLastName(String last);
}
