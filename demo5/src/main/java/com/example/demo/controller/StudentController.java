package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("student", studentService.getStudentByZ());
		return "student";
	}
	@GetMapping("/save/{id}")
	public String updateStudent(@PathVariable String id) {
		studentService.save1(id);
		return "redirect:/student/view";
	}
	
}
