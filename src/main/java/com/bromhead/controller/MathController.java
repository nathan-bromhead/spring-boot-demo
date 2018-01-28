package com.bromhead.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bromhead.model.ErrorModel;
import com.bromhead.model.IModel;
import com.bromhead.model.MathModel;
import com.bromhead.service.IMathService;

@RestController
@RequestMapping("/math")
public class MathController {

	@Autowired
	private IMathService mathService;
	
	@GetMapping("/add")
	public ResponseEntity<IModel> add(
			@RequestParam String n1, 
			@RequestParam String n2) {
		
		IModel result = validateParameters(n1, n2);

		if (result == null)
			result = doAddRequest(n1, n2);
		
		return new ResponseEntity<IModel>(result, result.getResponseCode());
	}
	
	@PostMapping("/add")
	public ResponseEntity<IModel> add(HttpServletRequest request,
			@RequestParam(value="1", required=true) String n1,
			@RequestParam(value="2", required=true) String n2) {
		
		IModel result = validateParameters(n1, n2);
		
		if (result == null)
			result = doAddRequest(n1, n2);
		
		return new ResponseEntity<IModel>(result, result.getResponseCode());
	}
	
	/**
	 * Validates the numeric values from the scary Internet. Some duplication of code here, as the service 
	 * will make this check as well.
	 */
	private IModel validateParameters(String param1, String param2) {
		IModel toReturn = null;

		if (!isParameterValid(param1))
			toReturn = new ErrorModel(param1 + " is not a valid numeric value", HttpStatus.UNPROCESSABLE_ENTITY);

		if (!isParameterValid(param2))
			toReturn = new ErrorModel(param2 + " is not a valid numeric value", HttpStatus.UNPROCESSABLE_ENTITY);
		
		return toReturn;
	}
	
	private boolean isParameterValid(String param) {
		return NumberUtils.isNumber(param);
	}
	
	private IModel doAddRequest(String param1, String param2) {
		IModel toReturn = null;
		
		try {
			
			BigDecimal result = mathService.add(param1, param2);
			toReturn = new MathModel(result, HttpStatus.OK);
			
		} catch (Exception e) {
			// A bit of a hassle, but check if the exception was an IllegalArgumentException. Having a separate
			//	catch above the general Exception will not work.
			if (e instanceof IllegalArgumentException)
				toReturn = new ErrorModel(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			else
				toReturn = new ErrorModel("An unknown error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
		return toReturn;
	}
}
