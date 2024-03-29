package com.util.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author arul
 *
 */
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@ComponentScan("com.util.ms")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
