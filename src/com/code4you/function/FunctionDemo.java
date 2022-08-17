package com.code4you.function;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<String, String> upperCaseConversion = (str)-> str.toUpperCase();
		Function<String, String> concatOperation = (str)-> str.concat(" ,you are welcome!");
		
		String UPName = upperCaseConversion.apply("Dharamveer");
		System.out.println("upperCaseConversion- "+UPName);
		
		String concateResult = concatOperation.apply("Dharamveer");
		System.out.println("concatOperation- "+concateResult);
		
		String UPAndConcatResult = upperCaseConversion.andThen(concatOperation).apply("Dharamveer");
		System.out.println("Uppercase and concate- "+UPAndConcatResult);
		
		String UPComposeConcatResult = upperCaseConversion.compose(concatOperation).apply("Dharamveer");
		System.out.println("Uppercase compose concate- "+UPComposeConcatResult);
	}

}
