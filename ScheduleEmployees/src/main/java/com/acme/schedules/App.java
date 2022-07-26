package com.acme.schedules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.acme.schedules.controller.EmployeeController;
import com.acme.schedules.dao.EmployeeDao;
import com.acme.schedules.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao employeeDao=new EmployeeDao("src/main/file/inputs.txt");
        EmployeeController controller = new EmployeeController();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
        	employees=(ArrayList<Employee>) employeeDao.getEmployees();
        	for(int i=0;i<employees.size();i++) {
        		for(int j=i+1;j<employees.size();j++) {
        			controller.compareEmployeeSchedules(employees.get(i), employees.get(j));        			
        		}
        	}
        	EmployeeController.showEmployeesWithSharedSchedule();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
}
