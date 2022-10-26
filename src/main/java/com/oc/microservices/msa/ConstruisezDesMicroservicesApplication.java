package com.oc.microservices.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.oc.microservices.msa.controllers","com.oc.microservices.msa.dao"})
public class ConstruisezDesMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstruisezDesMicroservicesApplication.class, args);
	}

}
