package com.spring.springbootsimpleproject.sorting;

import java.util.Comparator;

import com.spring.springbootsimpleproject.dto.Student;

public class SortStudentByName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getStudentName().compareTo(o2.getStudentName());
	}

	
}
