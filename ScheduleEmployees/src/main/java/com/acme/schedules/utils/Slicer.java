package com.acme.schedules.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.acme.schedules.model.Employee;

public class Slicer {
	public static Employee sliceEmployeeAndSchedule(String line) {
		Employee employee = new Employee();
		String linea = normalizeString(line);
		String[] data = linea.split("=");
		String[] schedule = data[1].split(",");
		employee.setName(data[0]);
		employee.setWorkSchedule(getEmployeeSchedule(schedule));
		return employee;
	}
	
	public static HashMap<String,ArrayList<String>> getEmployeeSchedule(String[] employeeSchedule){
		HashMap<String,ArrayList<String>> empSchedule = new HashMap<String, ArrayList<String>>();
		for(String schedule:employeeSchedule) {
			String day = schedule.substring(0,2);
			String hours = schedule.substring(2);
			empSchedule.put(day, getEmployeeHours(hours));
		}
		return empSchedule;
	}
	
	public static ArrayList<String> getEmployeeHours(String line) {
		ArrayList<String> employeeHours = new ArrayList<String>();
		String[] hours=line.split("-");
		for(String hour:hours) {
			employeeHours.add(hour);
		}
		return employeeHours;
	}
	
	public static int getHourOnMinutes(String line) {
		int totalMinutes = 0;
		String[] hour=line.split(":");
		int hourToMinutes = Integer.parseInt(hour[0]) * 60;
		int minutes = Integer.parseInt(hour[1]);
		totalMinutes = hourToMinutes + minutes; 
		return totalMinutes;
	}
	
	public static String normalizeString(String line) {
		String normalizedText="";
		normalizedText= line.replaceAll(" ", "");
		return normalizedText;
	}
}
