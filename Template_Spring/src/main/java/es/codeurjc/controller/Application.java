package es.codeurjc.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "es.codeurjc")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);}
}