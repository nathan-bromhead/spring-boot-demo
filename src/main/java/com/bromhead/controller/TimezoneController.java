package com.bromhead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bromhead.model.TimezoneModel;
import com.bromhead.service.ITimezoneService;

@RestController
@RequestMapping("/time")
public class TimezoneController {
	
	@Autowired
	private ITimezoneService timezoneService;
	
	@GetMapping("/now")
	public ResponseEntity<Object>now() {
		
		TimezoneModel model = timezoneService.getTimeZone("YYC");
		
		return new ResponseEntity<Object>(model, HttpStatus.OK);
	}

}
