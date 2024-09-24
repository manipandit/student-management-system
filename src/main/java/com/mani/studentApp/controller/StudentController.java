package com.mani.studentApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mani.studentApp.entity.Student;
import com.mani.studentApp.service.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		
		return "student";
	}
	
	@GetMapping("/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		
		model.addAttribute("students", student);
		return "newstudent";
	}
	
	@PostMapping("/add")
	public String saveStudent(@ModelAttribute ("student") Student student) {
		studentService.saveStudent(student);
		
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String updateStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getById(id));
		
		return "update_student";
	}
	
	@PostMapping("/edit/{id}")
	public String updateStudentInfo(@PathVariable int id, @ModelAttribute("student") Student student) {
		Student exisitingStudent = studentService.getById(id);
		
		exisitingStudent.setFirstName(student.getFirstName());
		exisitingStudent.setLastName(student.getLastName());
		exisitingStudent.setEmail(student.getEmail());
		
		studentService.saveStudent(exisitingStudent);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
	
}
