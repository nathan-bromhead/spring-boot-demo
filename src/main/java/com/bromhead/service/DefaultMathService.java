package com.bromhead.service;

import java.math.BigDecimal;

public class DefaultMathService implements IMathService {

	@Override
	public BigDecimal add(String param1, String param2) {
		
		BigDecimal operand1 = new BigDecimal(param1);
		BigDecimal operand2 = new BigDecimal(param2);
		
		return operand1.add(operand2);
	}
	
}
