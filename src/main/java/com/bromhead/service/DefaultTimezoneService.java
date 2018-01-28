package com.bromhead.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bromhead.component.DemoProperties;
import com.bromhead.dto.TimezoneDto;

@Service
public class DefaultTimezoneService implements ITimezoneService {
	
	@Autowired
	private DemoProperties props;
	
	private final String TIMEZONE_URI = "https://www.amdoren.com/api/timezone.php?api_key=${API_KEY}&loc=Calgary"; 

	@Override
	public TimezoneDto getTimeZone(String cityCode) {
		String uri = getTimeZoneUri();
		
		TimezoneDto toReturn;
		RestTemplate restTemplate = new RestTemplate();
		
		toReturn = restTemplate.getForObject(uri, TimezoneDto.class);
		toReturn.setLocation("Calgary");
		
		return toReturn;
	}
	
	private String getTimeZoneUri() {
		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("API_KEY", props.getTimezoneApiKey());
		
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		
		return sub.replace(TIMEZONE_URI);
	}

}
