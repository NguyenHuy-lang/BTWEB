package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.entity.Student;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	@Override
	public List<Student> getStudentByZ() {
		return studentRepository.getListStudent();
	}
	@Override
	public Student getStudentById(String id) {
		return studentRepository.findById(id).orElse(null);
	}
	@Override
	public Student save(Student s) {
		return studentRepository.save(s);
	}
	@Transactional
	@Override
	public void save1(String code) {
		Student student = studentRepository.findById(code).orElse(null);
		if(student!=null) {
			student.setApproved(Integer.parseInt("1"));
			studentRepository.save(student);

		}
	}
	

}
