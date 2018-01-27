package com.bromhead.service;

import java.math.BigDecimal;

import org.apache.commons.lang3.math.NumberUtils;

public class DefaultMathService implements IMathService {

	@Override
	public BigDecimal add(String param1, String param2) {
		validateParamIsNumber(param1);
		validateParamIsNumber(param2);
		
		BigDecimal operand1 = new BigDecimal(param1);
		BigDecimal operand2 = new BigDecimal(param2);
		
		return operand1.add(operand2);
	}
	
	private void validateParamIsNumber(String param) {
		if (!NumberUtils.isNumber(param))
			throw new IllegalArgumentException(param + " is not a valid numeric value");
	}
	
	
}
