package com.bromhead.unit;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.bromhead.service.DefaultMathService;
import com.bromhead.service.IMathService;

public class MathServiceTest {

	private IMathService service;
	
	@Before
	public void setup() {
		service = new DefaultMathService();
	}
	
	@Test
	public void testAdd_integers() {
		String param1 = "10";
		String param2 = "15";
		BigDecimal expectedResult = new BigDecimal("25");
		
		BigDecimal actualResult = service.add(param1, param2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAdd_floatingPoint() {
		String param1 = "10.82";
		String param2 = "15.78965";
		BigDecimal expectedResult = new BigDecimal("26.60965");
		
		BigDecimal actualResult = service.add(param1, param2);
		
		assertEquals(expectedResult, actualResult);
	}

}
