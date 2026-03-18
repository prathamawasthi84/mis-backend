package com.example.MIS.and.Invoicing.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MisAndInvoicingSystemApplication {

	public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("Admin@12345"));
		SpringApplication.run(MisAndInvoicingSystemApplication.class, args);
	}

}
