package com.acme.schedules.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.acme.schedules.model.Employee;
import com.acme.schedules.utils.Conversor;
import com.acme.schedules.utils.Slicer;

public class EmployeeController {
	private static Set<String> employeesWithSharedSchedule = new HashSet<String>();

	public static void showEmployeesWithSharedSchedule() {
		for(String schedule: employeesWithSharedSchedule) {
			System.out.println(schedule);
		}
	}

	public Set<String> getEmployeesWithSharedSchedule() {
		return employeesWithSharedSchedule;
	}
	
	public void compareEmployeeSchedules(Employee employee1, Employee employee2) {
		HashMap<String, ArrayList<String>> employee1Data = employee1.getWorkSchedule();
		HashMap<String, ArrayList<String>> employee2Data = employee2.getWorkSchedule();
		int totalHours = 0;
		int employee1InitialHourOnMinutes = 0;
		int employee1FinalHourOnMinutes = 0;
		int employee2InitialHourOnMinutes = 0;
		int employee2FinalHourOnMinutes = 0;
		for (Map.Entry<String, ArrayList<String>> entry1 : employee1Data.entrySet()) {
			String key = entry1.getKey();
			if (employee2Data.containsKey(key)) {
				ArrayList<String> value1 = entry1.getValue();
				ArrayList<String> value2 = employee2Data.get(key);
				employee1InitialHourOnMinutes = Slicer.getHourOnMinutes(value1.get(0));
				employee1FinalHourOnMinutes = Slicer.getHourOnMinutes(value1.get(1));
				employee2InitialHourOnMinutes = Slicer.getHourOnMinutes(value2.get(0));
				employee2FinalHourOnMinutes = Slicer.getHourOnMinutes(value2.get(1));
				totalHours += getSharedMinutes(employee1InitialHourOnMinutes, employee1FinalHourOnMinutes,
						employee2InitialHourOnMinutes, employee2FinalHourOnMinutes);
			}
		}
		String employeeWithSharedSchedule=employee1.getName() + " - " + employee2.getName() + " - " + Conversor.convertMinutesToHours(totalHours) +":"+Conversor.getRemainingMinutes(totalHours);
		employeesWithSharedSchedule.add(employeeWithSharedSchedule);
	}

	public int getSharedMinutes(int initialMinutes, int finalMinutes, int initialMinutesToCompare,
			int finalMinutesToCompare) {
		/*
		 * POSSIBLE CASES:
		 * e1i     e2i     e2f    e1f
		 * e1i     e2i     e1f    e2f
		 * e2i     e1i     e2f    e1f
		 */
		int minuteShared = 0;
		if(initialMinutes<initialMinutesToCompare) {
			
			if(initialMinutes<=initialMinutesToCompare && finalMinutesToCompare<=finalMinutes) {
				minuteShared = finalMinutesToCompare - initialMinutesToCompare;
			}else if (initialMinutes <= initialMinutesToCompare && initialMinutesToCompare <= finalMinutes && finalMinutes<=finalMinutesToCompare) {
				minuteShared = finalMinutes - initialMinutesToCompare;
			} else if (finalMinutesToCompare<= initialMinutes && initialMinutes <= finalMinutesToCompare && finalMinutesToCompare<= finalMinutes) {
				minuteShared = finalMinutesToCompare - initialMinutes;
			}
		}else {
			if(initialMinutesToCompare<=initialMinutes && finalMinutes<=finalMinutesToCompare) {
				minuteShared = finalMinutes - initialMinutes;
			}else if (initialMinutesToCompare<=initialMinutes  && initialMinutes <= finalMinutesToCompare && finalMinutesToCompare<=finalMinutes) {
				minuteShared = finalMinutes - initialMinutesToCompare;
			} else if (finalMinutes<= initialMinutesToCompare && initialMinutes <= finalMinutesToCompare && finalMinutesToCompare<= finalMinutes) {
				minuteShared = finalMinutesToCompare - initialMinutes;
			}
		}
		return minuteShared;
	}
}
