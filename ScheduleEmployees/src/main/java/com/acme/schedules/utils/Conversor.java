package com.acme.schedules.utils;

public class Conversor {
	public static int convertHoursToMinutes(int hours) {
		return hours*60;
	}
	
	public static int convertMinutesToHours(int minutes) {
		return minutes/60;
	}
	
	public static int getRemainingMinutes(int time) {
		return time%60;
	}
}
