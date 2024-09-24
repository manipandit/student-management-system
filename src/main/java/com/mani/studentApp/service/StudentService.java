package com.mani.studentApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mani.studentApp.entity.Student;

@Service
public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getById(int id);
	
	void deleteStudentById(int id);
}
