package com.bromhead.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoProperties {

	@Value("${timzoneKey}")
	private String timezoneApiKey;

	public String getTimezoneApiKey() {
		return timezoneApiKey;
	}
	
	
}
