package com.code4you.entity.dao;

import java.util.Arrays;
import java.util.List;

import com.code4you.entity.Student;

public class StudentDao {
	
	public static List<Student> getAllStudents(){
		
		Student student1 = new Student("John", 2, 3.5, "Male", Arrays.asList("cricket","running","travelling"));
		Student student2 = new Student("Rohan", 2, 3.0, "Male", Arrays.asList("vallyball","walking","table tennis"));
		Student student3 = new Student("Abhinav", 3, 4.0, "Male", Arrays.asList("hockey","ludo","badminton"));
		Student student4 = new Student("Shubham", 3, 2.5, "Male", Arrays.asList("foodie","reading","singing"));
		Student student5 = new Student("Toshi", 4, 3.9, "Female", Arrays.asList("tennis","travelling","writting"));
		Student student6 = new Student("Ramesh", 4, 4.2, "Male", Arrays.asList("badminton","coding","foodie"));
		Student student7 = new Student("Toshi", 4, 4.5, "Female", Arrays.asList("tennis","travelling","writting"));
		
		List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5,student6,student7);
		
		return studentList;
	}
	
public static List<Student> getAllWithNullStudents(){
		
		Student student1 = new Student("John", 2, 3.5, "Male", Arrays.asList("cricket","running","travelling"));
		Student student2 = new Student("Rohan", 2, 3.0, "Male", Arrays.asList("vallyball","walking","table tennis"));
		Student student3 = new Student("Abhinav", 3, 4.0, "Male", Arrays.asList("hockey","ludo","badminton"));
		Student student4 = new Student("Shubham", 3, 2.5, "Male", Arrays.asList("foodie","reading","singing"));
		Student student5 = new Student("Toshi", 4, 3.9, "Female", Arrays.asList("tennis","travelling","writting"));
		Student student6 = new Student("Ramesh", 4, 4.2, "Male", Arrays.asList("badminton","coding","foodie"));
		Student student7 = new Student("Toshi", 4, 4.5, "Female", Arrays.asList("tennis","travelling","writting"));
		
		List<Student> studentList = Arrays.asList(student1,student2,null,student3,student4,student5,null,student6,student7);
		
		return studentList;
	}
	
	public static List<Student> getAllStudentsWithNotebook(){
		
		Student student1 = new Student("John", 2, 3.5, "Male", Arrays.asList("cricket","running","travelling"),5);
		Student student2 = new Student("Rohan", 2, 3.0, "Male", Arrays.asList("vallyball","walking","table tennis"),6);
		Student student3 = new Student("Neeriksha", 3, 4.0, "Female", Arrays.asList("hockey","ludo","badminton"),2);
		Student student4 = new Student("Shubham", 3, 2.5, "Male", Arrays.asList("foodie","reading","singing"),10);
		Student student5 = new Student("Toshi", 4, 3.9, "Female", Arrays.asList("tennis","travelling","writting"),7);
		Student student6 = new Student("Ramesh", 4, 4.2, "Male", Arrays.asList("badminton","coding","foodie"),1);
		
		List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5,student6);
		
		return studentList;
	}
	
	public static Student getStudent(){
		return new Student("John", 2, 3.5, "Male", Arrays.asList("cricket","running","travelling"));
	}
}
