package br.com.lucassdezembro.utils;

public class ParserUtils {

	static public Double stringToDouble(String number) {
		if (number == null) return 0D;
		
		// trocando as vírgulas (do formato BR) para ponto (formato americano)
		String formattedNumber = number.replaceAll(",", ".");
		
		if (VerificationUtils.isNumber(formattedNumber)) return Double.parseDouble(formattedNumber);
		
		return 0D;
	}
}
