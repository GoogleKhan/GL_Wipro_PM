package com.wipro;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.mysql.cj.jdbc.Driver;

public class Main {

	private static final String URL = "jdbc:mysql://localhost:3306/spring_jdbc_db";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static void main(String[] args) {

		EmployeeDAO employeeDAO = new EmployeeDAO(getJdbcTemplate());

		Employee emp1 = new Employee(102, "Rahul K", 7788.67);
		//employeeDAO.save(emp1);
		//employeeDAO.edit(emp1);
		
		System.out.println(employeeDAO.getAll());
		employeeDAO.delete(102);
		System.out.println(employeeDAO.getAll());

	}

	private static JdbcTemplate getJdbcTemplate() {

		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setDriverClass(Driver.class);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}

}
