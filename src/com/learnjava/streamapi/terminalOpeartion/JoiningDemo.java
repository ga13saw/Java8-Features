package com.learnjava.streamapi.terminalOpeartion;

import static java.util.stream.Collectors.joining;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class JoiningDemo {
	
	public static String joining_1() {
		return StudentDao.getAllStudents().stream()
				.map(Student::getName)
				.collect(joining());
	}
	
	public static String joining_2() {
		return StudentDao.getAllStudents().stream()
				.map(Student::getName)
				.collect(joining("-"));
	}
	
	public static String joining_3() {
		return StudentDao.getAllStudents().stream()
				.map(Student::getName)
				.collect(joining("-","(",")"));
	}
	
	public static void main(String[] args) {
		System.out.println(joining_1());
		System.out.println(joining_2());
		System.out.println(joining_3());

	}

}
