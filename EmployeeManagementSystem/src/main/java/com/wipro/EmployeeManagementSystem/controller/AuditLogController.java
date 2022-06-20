package com.wipro.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.EmployeeManagementSystem.model.AuditLog;
import com.wipro.EmployeeManagementSystem.repository.AuditLogRepository;

@RestController
public class AuditLogController {

	@Autowired
	private AuditLogRepository auditLogRepository;

	
	@GetMapping("/logs")
	public List<AuditLog> getAllLogs() {
		return auditLogRepository.findAll();
	}

}
