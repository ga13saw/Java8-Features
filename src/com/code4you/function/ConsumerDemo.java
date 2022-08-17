package com.code4you.function;

import java.util.List;
import java.util.function.Consumer;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class ConsumerDemo {
	
	private Consumer<Student> consumeStudent = (student)-> System.out.print(student.getName()+" ");
	private Consumer<Student> consumeStudent2 = (student)-> System.out.println(student.getActivities());
	private List<Student> allStudents = StudentDao.getAllStudents();
	
	private void printStudentsName() {
		System.out.println("inside method printStudentsName");
		allStudents.forEach(consumeStudent);
	}
	
	private void printStudentsNameAndActivities() {
		System.out.println("\ninside method printStudentsNameAndActivities");
		
		allStudents.forEach(student->{
			consumeStudent.andThen(consumeStudent2).accept(student);
		});
	}
	
	

	public static void main(String[] args) {
		
		Consumer<String> studentName = (name)-> System.out.println(name.toUpperCase());
		Consumer<String> studentName2 = (name)-> System.out.println(name.toLowerCase());
		studentName.accept("John");
		studentName.andThen(studentName2).accept("Rohit");;
		
		ConsumerDemo consumerDemo = new ConsumerDemo();
		consumerDemo.printStudentsName();
		consumerDemo.printStudentsNameAndActivities();
		
		
	}

}
