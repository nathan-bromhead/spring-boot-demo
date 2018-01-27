package com.bromhead.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bromhead.service.DefaultMathService;
import com.bromhead.service.IMathService;

@RestController
@RequestMapping("/math")
public class MathController {

	private IMathService mathService;
	
	public MathController() {
		mathService = new DefaultMathService();
	}
	
	
	@GetMapping("/add")
	public ResponseEntity<Object> add(@RequestParam String n1, @RequestParam String n2) {
		BigDecimal result = mathService.add(n1, n2);
		
		Map<String, String> response = new HashMap<>();
		response.put("sum", result.toString());
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(HttpServletRequest request,
			@RequestParam(value="1", required=true) String n1,
			@RequestParam(value="2", required=true) String n2) {
		
		BigDecimal result = mathService.add(n1, n2);

		Map<String, String> response = new HashMap<>();
		response.put("sum", result.toString());
		
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
