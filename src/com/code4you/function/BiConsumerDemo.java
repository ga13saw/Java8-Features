package com.code4you.function;

import java.util.List;
import java.util.function.BiConsumer;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class BiConsumerDemo {
	
	private List<Student> allStudents = StudentDao.getAllStudents();
	private BiConsumer<String, List<String>> consumeStudent = (name,activities)-> System.out.println(name+": "+activities);
	
	private void printStudentsNameAndActivities() {
		System.out.println("\ninside method printStudentsNameAndActivities");
		
		allStudents.forEach(student->{
			consumeStudent.accept(student.getName(), student.getActivities());
		});
	}
	
	public static void main(String[] args) {
		BiConsumerDemo consumerDemo = new BiConsumerDemo();
		consumerDemo.printStudentsNameAndActivities();

	}

}
