package com.bromhead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bromhead.dto.TimezoneDto;
import com.bromhead.model.ErrorModel;
import com.bromhead.model.IModel;
import com.bromhead.model.TimezoneModel;
import com.bromhead.service.ITimezoneService;

@RestController
@RequestMapping("/time")
public class TimezoneController {
	
	@Autowired
	private ITimezoneService timezoneService;
	
	@GetMapping("/now")
	public ResponseEntity<IModel>now() {
		
		// City code is just an example for the purposes of this demo
		IModel response = getTimeZone("YYC");
		
		return new ResponseEntity<IModel>(response, response.getResponseCode());
	}
	
	private IModel getTimeZone(String cityCode) {
		IModel toReturn;
		
		try {
			TimezoneDto response = timezoneService.getTimeZone(cityCode);
			toReturn = new TimezoneModel(response.getTimezone(), response.getTime(), response.getLocation());
			
		} catch (Exception e) {
			toReturn = new ErrorModel("An unknown error has occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return toReturn;
	}
}
