package com.code4you.parallelstream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CompareSeqPara {

	static long measurePerformance(Supplier<Integer> supp, int num) {
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < num; i++) {
			supp.get();
		}
		long endTime = System.currentTimeMillis();
		
		return endTime-startTime;
	}
	
	public static int sequentialSum() {
		return IntStream.rangeClosed(1, 100000000).sum();
	}
	
	public static int paralleSum() {
		return IntStream.rangeClosed(1, 100000000).parallel().sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Available Processor: "+ Runtime.getRuntime().availableProcessors());
		System.out.println("Sequential sum: "+ measurePerformance(CompareSeqPara::sequentialSum, 10));
		System.out.println("Parallel sum: "+ measurePerformance(CompareSeqPara::paralleSum, 10));
	}

}
