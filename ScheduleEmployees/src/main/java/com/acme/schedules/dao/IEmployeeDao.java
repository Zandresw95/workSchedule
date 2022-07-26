package com.acme.schedules.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.acme.schedules.model.Employee;

public interface IEmployeeDao {
	public List<Employee> getEmployees()throws FileNotFoundException,IOException;
}
