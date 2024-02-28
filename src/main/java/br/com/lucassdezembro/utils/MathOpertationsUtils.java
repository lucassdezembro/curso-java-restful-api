package br.com.lucassdezembro.utils;

public class MathOpertationsUtils {

	public static Double sum(Double... values) {
		Double sum = 0D;
		for (Double value : values) {
			sum += value;
		}
		return sum;
	}
	
	public static Double subtract(Double... values) {
		Double subtraction = null;
		for (Double value : values) {
			subtraction = subtraction == null ? value : subtraction - value;
		}
		return subtraction;
	}
	
	public static Double multiply(Double... values) {
		Double product = null;
		for (Double value : values) {
			product = product == null ? value : product * value;
		}
		return product;
	}
	
	public static Double divide(Double... values) {
		Double quotient = null;
		for (Double value : values) {
			quotient = quotient == null ? value : quotient / value;
		}
		return quotient;
	}
	
	public static Double average(Double... values) {
		Double sum = sum(values);
		return sum / values.length;
	}
	
	public static Double sqrt(Double value) {
		return Math.sqrt(value);
	}
}
