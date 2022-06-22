package com.wipro.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.firstapp.model.GreatLearning;
import com.wipro.firstapp.service.TestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@Autowired
	private TestService testService;

	@GetMapping("/info")
	public GreatLearning getInfo() {
		
		log.info("getInfo() started...");

		GreatLearning greatLearning = testService.getInfo();
		
		log.info("getInfo() ended...");

		return greatLearning;
	}

	@PostMapping("/custom-info")
	public GreatLearning getCustomInfo(String courseName, String courseType, String instructorName) {

		GreatLearning greatLearning = testService.getCustomInfo(courseName, courseType, instructorName);

		return greatLearning;
	}

}
