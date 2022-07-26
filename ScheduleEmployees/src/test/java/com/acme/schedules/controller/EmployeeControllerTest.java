package com.acme.schedules.controller;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.acme.schedules.model.Employee;
import com.acme.schedules.utils.Slicer;

public class EmployeeControllerTest {

	@Test
	public void testCompareEmployeeSchedules() {
		EmployeeController controller = new EmployeeController();
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		Set<String> employeesWithSharedSchedule = new HashSet<String>();
		employeesWithSharedSchedule.add("FRAN - ANDRES - 4:0");
		employee = Slicer.sliceEmployeeAndSchedule("FRAN=MO11:00-12:00,TH13:00-14:00,SU18:00-21:00");
		employee2 = Slicer.sliceEmployeeAndSchedule("ANDRES=MO11:00-13:00,TH13:15-14:00,SU18:45-21:00");
		controller.compareEmployeeSchedules(employee, employee2);
		assertEquals(true,employeesWithSharedSchedule.equals(controller.getEmployeesWithSharedSchedule()));
	}

	@Test
	public void testGetSharedMinutes() {
		EmployeeController controller = new EmployeeController();
		assertEquals(60, controller.getSharedMinutes(600, 720, 660, 720));
	}

}
