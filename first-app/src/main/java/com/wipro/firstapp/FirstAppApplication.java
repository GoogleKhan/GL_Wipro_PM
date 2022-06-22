package com.wipro.firstapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.firstapp.model.GreatLearning;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
		System.out.println("SpringBoot started....");

	}

	@Override
	public void run(String... args) throws Exception {

//		GreatLearning gl1 = new GreatLearning("Java", "IT", "Shadab");
//		System.out.println(gl1);
//		
//		GreatLearning gl2= new GreatLearning();
//		gl2.setCourseName("Angular");
//		gl2.setCourseType("IT");
//		gl2.setInstructorName("Khan");
//		
//		System.out.println(gl2);
		

	}

}
