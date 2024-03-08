package br.com.lucassdezembro.utils;

import java.lang.reflect.Array;
import java.util.List;

public class VerificationUtils {

	static public boolean isNumber(String number) {
		if (number == null) return false;
		
		String formattedNumber = number.replaceAll(",", ".");
		
		return formattedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	static public boolean isEmptyOrNull(Object value) {
		
		// independentemente do tipo, se for null já retorna true
		if (value == null) {
			return true;
		}
		
		// os tipos que retornam true em outras ocasiões são apenas strings e arrays
		if (value instanceof String) {
			return value == "";
		} else if (value.getClass().isArray()) {
			return Array.getLength(value) == 0; 
		} else {
			return false;
		}
	}
}
