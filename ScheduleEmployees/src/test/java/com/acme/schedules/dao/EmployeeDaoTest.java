package com.acme.schedules.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.acme.schedules.model.Employee;
import com.acme.schedules.utils.Slicer;

public class EmployeeDaoTest {

	@Test
	public void testGetEmployees() throws FileNotFoundException, IOException {
		List<Employee> employeeTest = new ArrayList<Employee>();
		EmployeeDao employeeDao=new EmployeeDao("src/main/file/testinput.txt");
		Employee employee = new Employee();
		employee= Slicer.sliceEmployeeAndSchedule("FRAN=MO11:00-12:00,TH13:00-14:00,SU18:00-21:00");
		employeeTest.add(employee);
		assertEquals(employeeTest, employeeDao.getEmployees());
	}

}
