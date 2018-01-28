package com.bromhead.model;

public class TimezoneModel {

	private String timezone;
	private String time;
	private String location;

	public TimezoneModel(String timezone, String time, String location) {
		super();
		this.timezone = timezone;
		this.time = time;
		this.location = location;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "TimezoneModel [timezone=" + timezone + ", time=" + time + ", location=" + location + "]";
	}
}
