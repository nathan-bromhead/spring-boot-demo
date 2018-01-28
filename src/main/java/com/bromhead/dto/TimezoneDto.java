package com.bromhead.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimezoneDto {
	
	@JsonProperty("timezone")
	private String timezone;
	
	@JsonProperty("time")
	private String time;
	
	private String location;
	
	public TimezoneDto() {
	}

	public TimezoneDto(String timezone, String time) {
		super();
		this.timezone = timezone;
		this.time = time;
	}
	
	public TimezoneDto(String timezone, String time, String location) {
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
	
	
	
	

}
