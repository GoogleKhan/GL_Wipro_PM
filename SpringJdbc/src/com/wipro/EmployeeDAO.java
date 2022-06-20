package com.wipro;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Employee employee) {

		String sql = "INSERT INTO employee VALUES(?,?,?)";

		jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getSalary());

		System.out.println("Employee saved...");
	}

	public void edit(Employee employee) {

		String sql = "UPDATE Employee SET name=?, salary=? WHERE id=?";
		jdbcTemplate.update(sql, employee.getName(), employee.getSalary(), employee.getId());

		System.out.println("Employee updated...");
	}

	public void delete(int id) {

		String sql = "DELETE FROM Employee WHERE id=?";
		jdbcTemplate.update(sql, id);

		System.out.println("Employee deleted...");
	}

	public Employee getOne(int id) {

		String sql = "SELECT * FROM Employee WHERE id=?";

		List<Employee> allEmployees = jdbcTemplate.query(sql, new Object[] { id }, new BeanPropertyRowMapper<>(Employee.class));

		if (allEmployees.size() > 0) {
			return allEmployees.get(0);
		} else {
			return null;
		}

	}

	public List<Employee> getAll() {

		String sql = "SELECT * FROM Employee";

		List<Employee> allEmployees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));

		return allEmployees;
	}

}
