package com.mani.studentApp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.studentApp.entity.Student;
import com.mani.studentApp.repo.StudentRepo;
import com.mani.studentApp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentsList = studentRepo.findAll();
		return studentsList;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}

}
