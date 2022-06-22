package com.wipro.firstapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.firstapp.model.Address;
import com.wipro.firstapp.model.GreatLearning;

@SpringBootApplication
public class FirstAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
		System.out.println("SpringBoot started....");

	}

	@Override
	public void run(String... args) throws Exception {

		Address address = Address.builder().city("Lucknow").state("UP").build();

		GreatLearning gl1 = GreatLearning.builder().build();
		System.out.println(gl1);

		GreatLearning gl2 = GreatLearning.builder().courseName("Java").address(address).build();
		System.out.println(gl2);

		GreatLearning gl3 = GreatLearning.builder().courseName("AWS").courseType("JOB").build();
		System.out.println(gl3);

		GreatLearning gl4 = GreatLearning.builder().courseName("DevOps").courseType("Training").instructorName("Shadab")
				.build();
		System.out.println(gl4);

//		GreatLearning gl1 = new GreatLearning();// Constructor Injection
//		System.out.println(gl1);
//
//		GreatLearning gl2 = new GreatLearning("Java");// Constructor Injection
//		System.out.println(gl2);
//
//		GreatLearning gl3 = new GreatLearning("AWS", "Job");// Constructor Injection
//		System.out.println(gl3);
//
//		GreatLearning gl4 = new GreatLearning("DevOps", "Training", "Shadab");// Constructor Injection
//		System.out.println(gl4);

//		GreatLearning gl2= new GreatLearning();// Setter Injecting
//		gl2.setCourseName("Angular");
//		gl2.setCourseType("IT");
//		gl2.setInstructorName("Khan");

//		System.out.println(gl2);

	}

}
