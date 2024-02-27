package br.com.lucassdezembro;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucassdezembro.exceptions.UnsupportedMathOperationException;

import br.com.lucassdezembro.errors.ConstantErrors;

@RestController
public class MathController {
	
	@GetMapping(value = "/sum/{number1}/{number2}")
	public Double sum(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		return convertedNumber1 + convertedNumber2;
	}
	
	@GetMapping(value = "/subtraction/{number1}/{number2}")
	public Double subtraction(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		return convertedNumber1 - convertedNumber2;
	}
	
	@GetMapping(value = "/multiplication/{number1}/{number2}")
	public Double multiplication(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		return convertedNumber1 * convertedNumber2;
	}
	
	@GetMapping(value = "/division/{number1}/{number2}")
	public Double division(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		return convertedNumber1 / convertedNumber2;
	}
	
	// TODO: quando aprender o POST, realizar a média com um array de números
	@GetMapping(value = "/average/{number1}/{number2}")
	public Double average(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numbersShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		// nota: para média de dois itens apenas, ficou complexo. No entanto, a ideia é posteriormente
		// fazer com que a função receba n números e devolva a média.
		
		List<Double> numbers = Arrays.asList(convertedNumber1, convertedNumber2);
		Double sum = 0D;
		
		for (Double number : numbers) {
			sum += number;
		}
		
		return sum / numbers.size();
	}
	
	@GetMapping(value = "/sqrt/{number1}")
	public Double sqrt(
			@PathVariable(value = "number1") String number1
	) throws Exception {
		
		if (!isNumber(number1)) {
			throw new UnsupportedMathOperationException(ConstantErrors.numberShouldBeString);
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		
		return Math.sqrt(convertedNumber1);
	}
	
	private boolean isNumber(String number) {
		if (number == null) return false;
		
		String formattedNumber = number.replaceAll(",", ".");
		
		return formattedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private Double stringToDouble(String number) {
		if (number == null) return 0D;
		
		// trocando as vírgulas (do formato BR) para ponto (formato americano)
		String formattedNumber = number.replaceAll(",", ".");
		
		if (isNumber(formattedNumber)) return Double.parseDouble(formattedNumber);
		
		return 0D;
	}
}
