package com.code4you.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctValue {

	public static void main(String[] args) {
		
	List<Integer> intList = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 6, 7, 8);
		
		List<Integer> result = new ArrayList<>();
		
		for (Integer integer : intList) {
			if(!result.contains(integer)) {
				result.add(integer);
			}
		}
		
		System.out.println(result);
		
		System.out.println("====================");
		
		List<Integer> collect = intList.stream()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(collect);
	}

}
