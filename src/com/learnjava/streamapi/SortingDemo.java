package com.learnjava.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class SortingDemo {

	static Supplier<List<Student>> nameWiseSortedStud = () -> {
		return StudentDao.getAllStudents().stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
	};

	static Supplier<List<Student>> nameWiseSortedStudDesc = () -> {
		return StudentDao.getAllStudents().stream().sorted(Comparator.comparing(Student::getName).reversed())
				.collect(Collectors.toList());
	};

	static Supplier<List<Student>> gpaWiseSortedStud = () -> {
		return StudentDao.getAllStudents().stream().sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());
	};

	public static void main(String[] args) {
		System.out.println(nameWiseSortedStud.get());
		
		System.out.println("========");
		System.out.println(gpaWiseSortedStud.get());

		System.out.println("========");
		System.out.println(nameWiseSortedStudDesc.get());

	}

}
