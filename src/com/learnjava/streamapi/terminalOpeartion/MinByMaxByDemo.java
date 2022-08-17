package com.learnjava.streamapi.terminalOpeartion;

import java.util.Comparator;
import java.util.Optional;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.maxBy;

public class MinByMaxByDemo {
	
	public static Optional<Student> minByDemo(){
		return StudentDao.getAllStudents().stream()
				.collect(minBy(Comparator.comparing(Student::getGpa)));
	}
	
	public static Optional<Student> maxByDemo(){
		return StudentDao.getAllStudents().stream()
				.collect(maxBy(Comparator.comparing(Student::getGpa)));
	}
	
	public static void main(String[] args) {
		System.out.println(minByDemo().get());
		System.out.println(maxByDemo().get());

	}

}
