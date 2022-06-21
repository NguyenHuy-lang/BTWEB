package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,String>{
	@Query(value="select * from student where approved >=1", nativeQuery = true)
	public List<Student> getListStudent();
	
	
}
