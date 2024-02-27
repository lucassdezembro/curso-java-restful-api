package br.com.lucassdezembro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucassdezembro.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	@GetMapping(value = "/sum/{number1}/{number2}")
	public Double sum(
			@PathVariable(value = "number1") String number1,
			@PathVariable(value = "number2") String number2
	) throws Exception {
		
		if (!isNumber(number1) || !isNumber(number2)) {
			throw new UnsupportedMathOperationException("Parameters 'number1' or 'number2' aren't numbers.");
		}
		
		Double convertedNumber1 = stringToDouble(number1);
		Double convertedNumber2 = stringToDouble(number2);
		
		return convertedNumber1 + convertedNumber2;
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
