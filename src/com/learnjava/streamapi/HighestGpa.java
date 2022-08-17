package com.learnjava.streamapi;

import java.util.Optional;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class HighestGpa {

	public static Optional<Student> getHighestGPAStudent(){
		return StudentDao.getAllStudents().stream()
				         .reduce((s1,s2)-> (s1.getGpa()>s2.getGpa()) ? s1 : s2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(getHighestGPAStudent().isPresent()) {
			System.out.println(getHighestGPAStudent().get());
		}
	}

}
