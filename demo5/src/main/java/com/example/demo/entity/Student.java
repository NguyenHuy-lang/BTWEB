package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Student")
public class Student {
	
	@Id
	private String id;
	@Column(columnDefinition = "TEXT")
	private String name;
	private Date dob;
	@Column(columnDefinition = "TEXT")
	private String department;
	private int approved;
	@PrePersist
	public void createAt() {
		this.dob=new Date();
	}
}
