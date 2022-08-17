package com.code4you.parallelstream;

import java.util.stream.IntStream;

public class InconsistantParallelResult {

	public static void main(String[] args) {
		Sum sum = new Sum();
		long start = System.currentTimeMillis();
		IntStream.rangeClosed(1, 1000000)
				.parallel()	//1991218834, 1263055041, 1552729690
				.forEach(sum::calculateSum);//705082704
		
		long end = System.currentTimeMillis();
		System.out.println("time: "+(end-start));
		System.out.println("sum: "+sum.getTotal().get());

	}

}
