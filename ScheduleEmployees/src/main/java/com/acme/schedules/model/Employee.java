package com.acme.schedules.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Employee {
	private String Name;
	private HashMap<String, ArrayList<String>> workSchedule = new HashMap<String, ArrayList<String>>();

	public Employee() {
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public HashMap<String, ArrayList<String>> getWorkSchedule() {
		return workSchedule;
	}

	public void setWorkSchedule(HashMap<String, ArrayList<String>> workSchedule) {
		this.workSchedule = workSchedule;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", workSchedule=" + workSchedule + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Name, workSchedule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(workSchedule, other.workSchedule);
	}

}
