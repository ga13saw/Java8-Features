package com.code4you.function;

import java.util.List;
import java.util.function.Predicate;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class StudentPredicateDemo {

	private List<Student> allStudents = StudentDao.getAllStudents();

	private Predicate<Student> gpaPredicate = (student) -> student.getGpa() > 3.0;
	private Predicate<Student> gradePredicate = (student) -> student.getGradeLevel() >= 3;

	private void filterStudentOnGpa() {
		System.out.println("inside filterStudentOnGpa");
		allStudents.forEach(student -> {
			if (gpaPredicate.test(student)) {
				System.out.println(student);
			}
		});
	}

	private void filterStudentOnGradeLevel() {
		System.out.println("inside filterStudentOnGradeLevel");
		allStudents.forEach(student -> {
			if (gradePredicate.test(student)) {
				System.out.println(student);
			}
		});

	}

	private void filterStudentOnGpaAndGradeLevel() {
		System.out.println("inside filterStudentOnGpaAndGradeLevel");
		allStudents.forEach(student -> {
			if (gpaPredicate.and(gradePredicate).test(student)) {
				System.out.println(student);
			}
		});

	}

	private void filterStudentOnGpaOrGradeLevel() {
		System.out.println("inside filterStudentOnGpaOrGradeLevel");
		allStudents.forEach(student -> {
			if (gpaPredicate.or(gradePredicate).test(student)) {
				System.out.println(student);
			}
		});

	}

	public Predicate<Student> getGpaPredicate() {
		return gpaPredicate;
	}

	public Predicate<Student> getGradePredicate() {
		return gradePredicate;
	}

	public static void main(String[] args) {
		StudentPredicateDemo predicateDemo = new StudentPredicateDemo();
		predicateDemo.filterStudentOnGpa();
		predicateDemo.filterStudentOnGradeLevel();
		predicateDemo.filterStudentOnGpaAndGradeLevel();
		predicateDemo.filterStudentOnGpaOrGradeLevel();

	}

}
