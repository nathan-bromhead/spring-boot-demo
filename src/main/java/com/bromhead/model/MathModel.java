package com.bromhead.model;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MathModel implements IModel {
	
	private String sum;
	private String error;
	
	@JsonIgnore
	private HttpStatus responseCode;

	public MathModel(BigDecimal sum, HttpStatus responseCode) {
		super();
		this.sum = sum.toString();
		this.responseCode = responseCode;
	}
	
	public MathModel(String error, HttpStatus responseCode) {
		super();
		this.error = error;
		this.responseCode = responseCode;
	}
	
	public boolean hasError() {
		return HttpStatus.OK != responseCode;
	}

	public String getSum() {
		return sum;
	}
	
	public void setSum(String sum) {
		this.sum = sum;
	}
	
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "MathModel [sum=" + sum + ", error=" + error + ", responseCode=" + responseCode + "]";
	}
	
}
