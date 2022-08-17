package com.code4you.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class StudentFunctionDemo {
	private List<Student> allStudents = StudentDao.getAllStudents();
	private StudentPredicateDemo predicateDemo = new StudentPredicateDemo();
	
	private Function<List<Student>, Map<String, Double>> studentNameAndGpa = (students) -> {
						Map<String, Double> resultMap = new HashMap<>();
						students.forEach(student -> {
							resultMap.put(student.getName(), student.getGpa());
						});
						return resultMap;
	};
	
	private Function<List<Student>, Map<String, Double>> studentNameAndGpaOnPredicate = (students) -> {
		Map<String, Double> resultMap = new HashMap<>();
		students.forEach(student -> {
			if(predicateDemo.getGpaPredicate().test(student)) {
				resultMap.put(student.getName(), student.getGpa());
			}
			
		});
		return resultMap;
};

	public static void main(String[] args) {
		StudentFunctionDemo demo = new StudentFunctionDemo();
		System.out.println("studentNameAndGpa- ");
		System.out.println(demo.studentNameAndGpa.apply(demo.allStudents));
		
		System.out.println("studentNameAndGpaOnPredicate- ");
		System.out.println(demo.studentNameAndGpaOnPredicate.apply(demo.allStudents));
	}

}
