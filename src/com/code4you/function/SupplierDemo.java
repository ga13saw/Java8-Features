package com.code4you.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class SupplierDemo {
	
	private static Supplier<Student> supplyAStudnet =
			()-> new Student("John", 2, 3.5, "Male", Arrays.asList("cricket","running","gymming"));
			
	private static Supplier<List<Student>> supplyStudnets =
			()-> StudentDao.getAllStudents();
	
	public static void main(String[] args) {
		System.out.println("supplyAStudnet-");
		System.out.println(supplyAStudnet.get());
		System.out.println("supplyStudnets-");
		System.out.println(supplyStudnets.get());

	}

}
