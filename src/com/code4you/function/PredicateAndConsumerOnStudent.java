package com.code4you.function;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class PredicateAndConsumerOnStudent {
	
	private List<Student> allStudents = StudentDao.getAllStudents();
	
	private Predicate<Student> gpaPredicate = (student)-> student.getGpa()>3.0;
	private Predicate<Student> gradePredicate = (student)-> student.getGradeLevel()>=3;
	private BiPredicate<Double, Integer> gpaAndGradePredicate = (gpa,grade)-> gpa>3.0 && grade >=3;
	
	private BiConsumer<String, List<String>> nameAndActivityConsumer = (name,activities)-> System.out.println(name+": "+activities);
	
	private Consumer<Student> studentConsumer = (student)->{
		if(gpaPredicate.and(gradePredicate).test(student)) {
			nameAndActivityConsumer.accept(student.getName(), student.getActivities());
		}
	};
	
	private Consumer<Student> studentConsumerWithBiPredicate = (student)->{
		if(gpaAndGradePredicate.test(student.getGpa(),student.getGradeLevel())) {
			nameAndActivityConsumer.accept(student.getName(), student.getActivities());
		}
	};
	
	private void printStudent(List<Student> studentList) {
		studentList.forEach(studentConsumer);
	}
	
	private void printStudentAproach2(List<Student> studentList) {
		studentList.forEach(studentConsumerWithBiPredicate);
	}
	
	
	public static void main(String[] args) {
		PredicateAndConsumerOnStudent onStudent = new PredicateAndConsumerOnStudent();
		System.out.println("printStudent");
		onStudent.printStudent(onStudent.allStudents);
		System.out.println("printStudentAproach2");
		onStudent.printStudentAproach2(onStudent.allStudents);

	}

}
