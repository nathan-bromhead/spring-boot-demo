package com.bromhead.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimezoneModel implements IModel {

	private String timezone;
	
	private String time;
	
	private String location;
	
	@JsonIgnore
	private HttpStatus responseCode;

	public TimezoneModel() {
		responseCode = HttpStatus.OK;
	}
	
	public TimezoneModel(String timezone, String time, String location) {
		super();
		this.timezone = timezone;
		this.time = time;
		this.location = location;
		responseCode = HttpStatus.OK;
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
	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseStatus) {
		this.responseCode = responseStatus;
	}

	@Override
	public String toString() {
		return "TimezoneModel [timezone=" + timezone + ", time=" + time + ", location=" + location + "]";
	}
}
