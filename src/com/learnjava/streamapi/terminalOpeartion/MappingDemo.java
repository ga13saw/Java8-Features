package com.learnjava.streamapi.terminalOpeartion;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.mapping;

import java.util.List;;

public class MappingDemo {

	public static List<String> name_mapping() {
		return StudentDao.getAllStudents().stream()
		 		.map(Student::getName)
		 		.collect(toList());
	}
	
	public static List<String> name_mapping2() {
		return StudentDao.getAllStudents().stream()
		 		.collect(mapping(Student::getName, toList()));
	}
	
	public static void main(String[] args) {
		System.out.println(name_mapping());
		System.out.println(name_mapping2());
	}

}
