package com.bromhead.service;

import com.bromhead.dto.TimezoneDto;

public interface ITimezoneService {
	
	public TimezoneDto getTimeZone(String cityCode);

}
