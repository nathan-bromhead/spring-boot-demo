package com.bromhead.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

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
	
	private String timeZoneApiUri;

	@Override
	/** Retrieves the timezone and time from the amdored api. The cityCode parameter is superfluous for this 
	 * example - it simply makes the method signature a bit more realistic, in that a consumer could pass a 
	 * code for individual cities. 
	 */
	public TimezoneDto getTimeZone(String cityCode) {
		String uri = timeZoneApiUri;
		
		TimezoneDto toReturn;
		RestTemplate restTemplate = new RestTemplate();
		
		toReturn = restTemplate.getForObject(uri, TimezoneDto.class);
		toReturn.setLocation("Calgary");
		
		return toReturn;
	}
	
	@PostConstruct
	private void buildTimezoneApiUri() {
		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("API_KEY", props.getTimezoneApiKey());
		
		StrSubstitutor sub = new StrSubstitutor(valueMap);
		timeZoneApiUri = sub.replace(TIMEZONE_URI);
	}

	
}
