package com.code4you.optional;

import java.util.Objects;
import java.util.Optional;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class OptionalDemo {

	static String getStudentName() {
		// Student student = StudentDao.getStudent();
		Student student = null;
		if (student != null) {
			return student.getName();

		}
		return null;
	}

	static String getStudentName2() {
		// Student student = StudentDao.getStudent();
		Student student = null;
		if (Objects.nonNull(student)) {
			return student.getName();

		}
		return null;
	}
	
	/*
	 * of - always accepts a non-null values
	 * ofNullable - null or non-null both
	 * isEmpty() - Optional.isempty
 	 */
	static Optional<Student> getStudentName3() {
		//Optional<Student> student = Optional.ofNullable(StudentDao.getStudent());
		Optional<Student> student = Optional.ofNullable(null);
		if (student.isPresent()) {
			return student;

		}
		return Optional.empty();
	}

	public static void main(String[] args) {

		// approach1
		/*
		 * String studentName = getStudentName(); if(studentName!=null) {
		 * System.out.println("Student name: "+ studentName); }else {
		 * System.out.println("No such student found"); }
		 */

		// approach2
		/*
		 * String studentName = getStudentName2(); if (Objects.nonNull(studentName)) {
		 * System.out.println("Student name: " + studentName); } else {
		 * System.out.println("No such student found"); }
		 */

		// approach3
		Optional<Student> studentName = getStudentName3();
		if (studentName.isPresent()) {
			System.out.println("Student name: " + studentName.get().getName());
		} else {
			System.out.println("No such student found");
		}
	}

}
