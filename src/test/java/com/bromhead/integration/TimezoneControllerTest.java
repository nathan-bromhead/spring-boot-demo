package com.bromhead.integration;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bromhead.controller.TimezoneController;
import com.bromhead.model.TimezoneModel;
import com.bromhead.service.ITimezoneService;

@RunWith(SpringRunner.class)
@WebMvcTest(TimezoneController.class)
public class TimezoneControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ITimezoneService service;
	

	@Before
	public void setup() {
		when(service.getTimeZone("YYC")).thenReturn(new TimezoneModel("Mountain Standard Time", "2018-01-27 17:27:35", "YYC"));
	}
	
	@Test
	public void testGetYYCTime() throws Exception {
		mockMvc
		.perform(get("/time/now"))
		.andExpect(content()
			.string(containsString("{\"timezone\":\"Mountain Standard Time\",\"time\":\"2018-01-27 17:27:35\",\"location\":\"YYC\"}")));
	
	}
}
