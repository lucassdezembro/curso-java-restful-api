package br.com.lucassdezembro.utils;

public class VerificationUtils {

	static public boolean isNumber(String number) {
		if (number == null) return false;
		
		String formattedNumber = number.replaceAll(",", ".");
		
		return formattedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
