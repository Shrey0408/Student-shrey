package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Studentconfiguration {
	@Bean
	
	CommandLineRunner commandlineRunner(StudentRepository studentRepository) {
		return args -> {
			Student shey = new Student("Shey",  "bc@gmail.com",LocalDate.of(2001,Month.JUNE, 21));
			Student sahay = new Student("Sahay", "axyz@gmail.com",LocalDate.of(2000,Month.APRIL, 2));
			Student said = new Student("Said", "olr@gmail.com",LocalDate.of(1999,Month.OCTOBER, 2));
			studentRepository.saveAll(List.of(shey,sahay,said));
		};
		
	}

}
