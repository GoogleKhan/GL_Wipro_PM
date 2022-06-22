package com.wipro.firstapp.service;

import org.springframework.stereotype.Service;

import com.wipro.firstapp.model.GreatLearning;

@Service
public class TestService {
	
	public GreatLearning getInfo() {

		GreatLearning greatLearning = GreatLearning.builder().courseName("AWS EC2").courseType("Job Oriented")
				.instructorName("Jeff").build();
		
		//Complex Login

		return greatLearning;
	}

	public GreatLearning getCustomInfo(String courseName, String courseType, String instructorName) {

		GreatLearning greatLearning = GreatLearning.builder().courseName(courseName).courseType(courseType)
				.instructorName(instructorName).build();
		
		// So many Code....

		return greatLearning;
	}


}
