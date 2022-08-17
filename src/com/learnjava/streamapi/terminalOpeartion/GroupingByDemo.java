package com.learnjava.streamapi.terminalOpeartion;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class GroupingByDemo {
	
	static Function<Student,String> gradeLevelSup = (stud)-> stud.getGpa()>3.5?"OUTSTANDING":"GOOD";
	
	public static Map<String,List<Student>> groupStudentsOnGender(){
		return StudentDao.getAllStudentsWithNotebook().stream()
				.collect(Collectors.groupingBy(Student::getGender));
	};
	
	public static Map<String,List<Student>> groupStudentsOnGpa(){
		return StudentDao.getAllStudentsWithNotebook().stream()
				.collect(Collectors.groupingBy(gradeLevelSup));
	};
	
	public static Map<String,Integer> groupStudentsOnGender3(){
		return StudentDao.getAllStudentsWithNotebook().stream()
				.collect(Collectors.groupingBy(Student::getGender,Collectors.summingInt(Student::getNoOfNoteBook)));
	};
	
	public static Map<String, Map<String, List<Student>>> groupStudentsOnGenderAndGpa(){
		return StudentDao.getAllStudentsWithNotebook().stream()
				.collect(Collectors.groupingBy(Student::getGender,Collectors.groupingBy(gradeLevelSup)));
	};
	
	public static Map<String,Student> groupStudentsOnGenderAndMaxGpa(){
		return StudentDao.getAllStudentsWithNotebook().stream()
				.collect(Collectors.groupingBy(
						Student::getGender,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),
								Optional::get)));
	};
	
	
	public static void main(String[] args) {
		
		System.out.println(groupStudentsOnGender());
		System.out.println("==============");
		System.out.println(groupStudentsOnGpa());
		
		System.out.println("==============");
		System.out.println(groupStudentsOnGender3());
		

		System.out.println("==============");
		System.out.println(groupStudentsOnGenderAndGpa());
		
		System.out.println("==============");
		System.out.println(groupStudentsOnGenderAndMaxGpa());
		
	}

}
