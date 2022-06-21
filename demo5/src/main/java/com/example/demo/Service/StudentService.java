package com.example.demo.Service;

import java.util.List;


import com.example.demo.entity.Student;

public interface StudentService {
	public List<Student> getStudentByZ();
	public Student getStudentById(String id);
	public Student save(Student s);
	public void save1(String code);

}
