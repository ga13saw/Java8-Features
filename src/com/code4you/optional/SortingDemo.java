package com.code4you.optional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class SortingDemo {
	
	static Comparator<Student> sortByNameComparator = Comparator.comparing(Student::getName);
	static Comparator<Student> sortByGpaComparator = Comparator.comparing(Student::getGpa);
	static Consumer<Student> studentConsumer = System.out::println;
	
	static void sortStudentsByName(List<Student> students){
		students.sort(sortByNameComparator);
		students.forEach(studentConsumer);
	}
	
	static void sortStudentsByGPA(List<Student> students){
		students.sort(sortByGpaComparator);
		students.forEach(studentConsumer);
	}
	
	static void sortStudentsByGPAStream(List<Student> students){
		List<Student> sortedStudents = students.stream()
				.sorted(sortByNameComparator)
				.collect(Collectors.toList());
		sortedStudents.forEach(studentConsumer);
	}
	
	static void sortStudentsByNameAndGPAStream(List<Student> students){
		List<Student> sortedStudents = students.stream()
				.sorted(sortByNameComparator.thenComparing(sortByGpaComparator).reversed())
				.collect(Collectors.toList());
		sortedStudents.forEach(studentConsumer);
	}
	
	//handling null values while sorting : nullsFirst(), nullsLast()
	static void sortWithNullStudentsByGPAStream(List<Student> students){
		List<Student> sortedStudents = students.stream()
				.sorted(Comparator.nullsLast(sortByNameComparator))
				.collect(Collectors.toList());
		sortedStudents.forEach(studentConsumer);
	}
	
	public static void main(String[] args) {
		List<Student> allStudents = StudentDao.getAllStudents();
		List<Student> allWithNullStudents = StudentDao.getAllWithNullStudents();
		System.out.println("GPA based sorting: ");
		sortStudentsByName(allStudents);
		System.out.println("==============Name based sorting:===============");
		sortStudentsByGPA(allStudents);
		System.out.println("=============GPA based sorting:================");
		sortStudentsByGPAStream(allStudents);
		System.out.println("=============Name and GPA based sorting:================");
		sortStudentsByNameAndGPAStream(allStudents);
		
		System.out.println("=============GPA based sorting with Null students:================");
		sortWithNullStudentsByGPAStream(allWithNullStudents);
		
		System.out.println("=============Older ways of sorting:================");
		Collections.sort(allStudents,sortByGpaComparator.reversed());
		allStudents.forEach(studentConsumer);
	}

}
