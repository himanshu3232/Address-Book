package com.capgemini.address_book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	public static void main(String[] args) {
		log.info("Springboot application started");
		SpringApplication.run(AddressBookApplication.class, args);
	}

}
