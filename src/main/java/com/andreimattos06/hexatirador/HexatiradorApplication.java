package com.andreimattos06.hexatirador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HexatiradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexatiradorApplication.class, args);
	}

}
