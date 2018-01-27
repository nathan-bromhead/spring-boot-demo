package com.bromhead.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bromhead.model.MathModel;
import com.bromhead.service.IMathService;

@RestController
@RequestMapping("/math")
public class MathController {

	@Autowired
	private IMathService mathService;
	
	@GetMapping("/add")
	public ResponseEntity<Object> add(@RequestParam String n1, @RequestParam String n2) {
		
		MathModel result = doAddRequest(n1, n2);
		
		return new ResponseEntity<Object>(result, result.getResponseCode());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(HttpServletRequest request,
			@RequestParam(value="1", required=true) String n1,
			@RequestParam(value="2", required=true) String n2) {
		
		MathModel result = doAddRequest(n1, n2);
		
		return new ResponseEntity<Object>(result, result.getResponseCode());
	}
	
	private MathModel doAddRequest(String param1, String param2) {
		MathModel toReturn = null;
		
		try {
			
			BigDecimal result = mathService.add(param1, param2);
			toReturn = new MathModel(result, HttpStatus.OK);
			
		} catch (Exception e) {
			
			if (e instanceof IllegalArgumentException)
				toReturn = new MathModel(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			else
				toReturn = new MathModel("An unknown error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
		return toReturn;
	}
}
