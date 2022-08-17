package com.learnjava.streamapi.terminalOpeartion;

import static java.util.stream.Collectors.counting;

import com.code4you.entity.dao.StudentDao;

public class CountingDemo {
	
	public static long countingDemo() {
		return StudentDao.getAllStudents().stream()
		   .filter(stu-> stu.getGpa()>3.5)
		   .collect(counting());
	}
	
	public static long countingDemo2() {
		return StudentDao.getAllStudents().stream()
		   .filter(stu-> stu.getGpa()>3.5 && stu.getGender().equals("Female"))
		   .collect(counting());
	}
	
	public static void main(String[] args) {
		System.out.println(countingDemo());
		System.out.println(countingDemo2());

	}

}
