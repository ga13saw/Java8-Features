package com.learnjava.streamapi;

import java.util.Optional;
import java.util.function.Predicate;

import com.code4you.entity.Student;
import com.code4you.entity.dao.StudentDao;

public class MapFilterReduceDemo {

	static Predicate<Student> studentGpaPredicate = s -> s.getGpa() > 3;

	public static void main(String[] args) {
		// approach 1
		Optional<Integer> reduce = StudentDao.getAllStudentsWithNotebook().stream().map(Student::getNoOfNoteBook)
				.reduce(Integer::sum);

		if (reduce.isPresent()) {
			System.out.println(reduce.get());
		}

		// approach 2
		Integer total = StudentDao.getAllStudentsWithNotebook().stream().map(Student::getNoOfNoteBook).reduce(0,
				Integer::sum);

		System.out.println(total);

		// approach 3
		Integer total2 = StudentDao.getAllStudentsWithNotebook().stream().filter(studentGpaPredicate)
				.peek(System.out::println).map(Student::getNoOfNoteBook).reduce(0, Integer::sum);

		System.out.println(total2);

		// approach 4  you can only use sum() when input is IntStream
		Integer total3 = StudentDao.getAllStudentsWithNotebook().stream().filter(studentGpaPredicate)
				.peek(System.out::println).mapToInt(Student::getNoOfNoteBook).sum();

		System.out.println(total3);

	}

}
