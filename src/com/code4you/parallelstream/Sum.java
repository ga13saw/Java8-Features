package com.code4you.parallelstream;

import java.util.concurrent.atomic.AtomicInteger;

public class Sum {
	private AtomicInteger total = new AtomicInteger();

	public AtomicInteger getTotal() {
		return total;
	}

	public  void calculateSum(int num) {
		
		total.addAndGet(num);
		//System.out.println(total.get());
	}
}
