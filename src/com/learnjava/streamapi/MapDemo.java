package com.learnjava.streamapi;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class MapDemo {

	public static void main(String[] args) {
		
		Function<Student, String> getStudentNames= (student)-> student.getName().toUpperCase();
		
		
		List<String> studentNames = StudentDao.getAllStudents().stream()
				  .map(Student::getName)
				  .map(String::toUpperCase)
				  .collect(Collectors.toList());
		
		System.out.println(studentNames);
		
		List<String> studentNamesApproach2 = StudentDao.getAllStudents().stream()
				  .map(getStudentNames)
				  .collect(Collectors.toList());
		
		System.out.println(studentNamesApproach2);
		
		//flatmap
		List<String> studentActivities = StudentDao.getAllStudents().stream() //Stream<Student>
		          .map(Student::getActivities) //Stream<List<String>>
		          .flatMap(List::stream)
		          .collect(Collectors.toList());
		
		System.out.println(studentActivities);
		
		//distinct
		List<String> studentActivities_distinct = StudentDao.getAllStudents().stream() //Stream<Student>
		          .map(Student::getActivities) //Stream<List<String>>
		          .flatMap(List::stream)
		          .distinct()
		          .collect(Collectors.toList());
		
		System.out.println(studentActivities_distinct);
		
		//count
		long studentActivities_count = StudentDao.getAllStudents().stream() //Stream<Student>
		          .map(Student::getActivities) //Stream<List<String>>
		          .flatMap(List::stream) //Stream<String>
		          .distinct()   
		          .count();
		          
		
		System.out.println(studentActivities_count);
		
		//sorted
		List<String> studentActivities_sorted = StudentDao.getAllStudents().stream() //Stream<Student>
		          .map(Student::getActivities) //Stream<List<String>>
		          .flatMap(List::stream)
		          .distinct()
		          .sorted()
		          .collect(Collectors.toList());
		
		System.out.println(studentActivities_sorted);
	}

}
