package br.com.lucassdezembro;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucassdezembro.exceptions.UnsupportedMathOperationException;
import br.com.lucassdezembro.utils.MathOpertationsUtils;
import br.com.lucassdezembro.utils.ParserUtils;
import br.com.lucassdezembro.utils.VerificationUtils;
import br.com.lucassdezembro.errors.ConstantErrors;

@RestController
public class MathController {
	
	@GetMapping(value = "/sum/{number1}/{number2}")
	public Double sum(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1) || !VerificationUtils.isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		Double convertedNumber2 = ParserUtils.stringToDouble(number2);
		
		return MathOpertationsUtils.sum(convertedNumber1, convertedNumber2);
	}
	
	@GetMapping(value = "/subtraction/{number1}/{number2}")
	public Double subtraction(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1) || !VerificationUtils.isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		Double convertedNumber2 = ParserUtils.stringToDouble(number2);
		
		return MathOpertationsUtils.subtract(convertedNumber1, convertedNumber2);
	}
	
	@GetMapping(value = "/multiplication/{number1}/{number2}")
	public Double multiplication(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1) || !VerificationUtils.isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		Double convertedNumber2 = ParserUtils.stringToDouble(number2);
		
		return MathOpertationsUtils.multiply(convertedNumber1, convertedNumber2);
	}
	
	@GetMapping(value = "/division/{number1}/{number2}")
	public Double division(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1) || !VerificationUtils.isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		Double convertedNumber2 = ParserUtils.stringToDouble(number2);
		
		return MathOpertationsUtils.divide(convertedNumber1, convertedNumber2);
	}
	
	// TODO: quando aprender o POST, realizar a média com um array de números
	@GetMapping(value = "/average/{number1}/{number2}")
	public Double average(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1) || !VerificationUtils.isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		Double convertedNumber2 = ParserUtils.stringToDouble(number2);
		
		return MathOpertationsUtils.average(convertedNumber1, convertedNumber2);
	}
	
	@GetMapping(value = "/sqrt/{number1}")
	public Double sqrt(
			@PathVariable(value = "number1") String number1
	) throws Exception {
		
		if (!VerificationUtils.isNumber(number1)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numberShouldBeString);
		}
		
		Double convertedNumber1 = ParserUtils.stringToDouble(number1);
		
		return MathOpertationsUtils.sqrt(convertedNumber1);
	}
}
