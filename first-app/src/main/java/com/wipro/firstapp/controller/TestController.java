package com.wipro.firstapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.firstapp.model.GreatLearning;

@RestController
public class TestController {

	@GetMapping("/info")
	public GreatLearning getInfo() {

		// GreatLearning greatLearning = new GreatLearning("AWS EC2", "Job Oriented",
		// "Jeff");

		GreatLearning greatLearning = GreatLearning.builder().courseName("AWS EC2").courseType("Job Oriented")
				.instructorName("Jeff").build();

		return greatLearning;
	}

	@PostMapping("/custom-info")
	public GreatLearning getCustomInfo(String courseName, String courseType, String instructorName) {

		GreatLearning greatLearning = GreatLearning.builder().courseName(courseName).courseType(courseType)
				.instructorName(instructorName).build();

		return greatLearning;
	}

}
