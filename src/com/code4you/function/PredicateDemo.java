package com.code4you.function;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		Predicate<Integer> isEven = (num)-> num%2==0;
		Predicate<Integer> isOdd = (num)-> num%2!=0;
		
		System.out.println("isEven.test(15) "+isEven.test(15));
		System.out.println("isEven.test(20) "+isEven.test(20));
		
		System.out.println("isOdd.test(15) "+isOdd.test(15));
		System.out.println("isOdd.test(20) "+isOdd.test(20));
		
		System.out.println("isEven.and(isOdd).test(55) "+isEven.and(isOdd).test(55));
		
		System.out.println("isEven.or(isOdd).test(55) "+isEven.or(isOdd).test(55));
		
		System.out.println("isOdd.negate().test(20) "+isOdd.negate().test(20));
	}

}
