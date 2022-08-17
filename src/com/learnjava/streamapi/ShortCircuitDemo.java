package com.learnjava.streamapi;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class ShortCircuitDemo {
	
	static Predicate<Student> anyMatchStudentGPA = student->student.getGpa()>3;
	static Predicate<Student> allMatchSudentGPA = student->student.getGpa()>1;
	
	public static void main(String[] args) {
		//limit
		List<Student> limitedStudent = StudentDao.getAllStudents().stream()
				.limit(3)
				.collect(Collectors.toList());
		
		//System.out.println(limitedStudent);
		
		//skip
				List<Student> skippedStudent = StudentDao.getAllStudents().stream()
						.skip(3)
						.collect(Collectors.toList());
				
				System.out.println(skippedStudent);
	
		//anyMatch, allMatch, noneMatch
				boolean anyMatchStudent = StudentDao.getAllStudents().stream()
						.anyMatch(anyMatchStudentGPA);
				
				System.out.println(anyMatchStudent);
				
				boolean noneMatchStudent = StudentDao.getAllStudents().stream()
						.noneMatch(anyMatchStudentGPA);
				
				System.out.println(noneMatchStudent);
				
				boolean allMatchStudent = StudentDao.getAllStudents().stream()
						.allMatch(allMatchSudentGPA);
				
				System.out.println(allMatchStudent);
				
				
		//findAny, findFirst
				 Optional<Student> findAnyStudent = StudentDao.getAllStudents().stream()
					.filter(anyMatchStudentGPA)
					.findAny();
			
				 if(findAnyStudent.isPresent())
					 	System.out.println(findAnyStudent.get());	
				 
				 Optional<Student> findFirstStudent = StudentDao.getAllStudents().stream()
							.filter(anyMatchStudentGPA)
							.findFirst();
					
						 if(findFirstStudent.isPresent())
							 	System.out.println(findFirstStudent.get());	
	}

}
