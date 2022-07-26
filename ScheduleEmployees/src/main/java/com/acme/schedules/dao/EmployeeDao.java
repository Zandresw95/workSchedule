package com.acme.schedules.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.acme.schedules.model.Employee;
import com.acme.schedules.utils.Slicer;

public class EmployeeDao implements IEmployeeDao{

	private String path = "";

	public EmployeeDao(String filePath) {
		this.path = filePath;
	}
	
	public List<Employee> getEmployees() throws FileNotFoundException,IOException {
		List<Employee> employees = new ArrayList<Employee>();
		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			String line = "";
			while ((line = br.readLine()) != null) {
				employees.add(Slicer.sliceEmployeeAndSchedule(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException("File not found at " + path);
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("There is a problem reading the file " + path);
		} finally {
			if (br != null) {
				br.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return employees;
	}

}
