package com.bromhead.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	
	@Test
	public void testAdd_invalidParam1() {
		String param1 = "not_a_number";
		String param2 = "15";
		
		try {
			service.add(param1, param2);
			fail("Test should have failed");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void testAdd_invalidParam2() {
		String param1 = "10";
		String param2 = "not_a_number";
		
		try {
			service.add(param1, param2);
			fail("Test should have failed");
		} catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void testAdd_LargeIntegers() {
		String param1 = "1000000000000000000000000000000000000000000000000000000000000000000000000";
		String param2 = "1500000000000000000000000000000000000000000000000000000000000000000000000";
		BigDecimal expectedResult = new BigDecimal("2500000000000000000000000000000000000000000000000000000000000000000000000");
		
		BigDecimal actualResult = service.add(param1, param2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAdd_LargeFloatingPoint() {
		String param1 = "789652325698542135.326589654784712596";
		String param2 = "9545848565489951751.365845145970540145740";
		
		BigDecimal expectedResult = new BigDecimal("10335500891188493886.692434800755252741740");

		BigDecimal actualResult = service.add(param1, param2);

		assertEquals(expectedResult, actualResult);
	}

}
