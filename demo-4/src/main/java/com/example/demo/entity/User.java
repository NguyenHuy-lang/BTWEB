package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	@NotEmpty
	@Id
	@Pattern(regexp="[1-9a-zA-Z]*", message = "ten chi gom chu va so")
	private String username;
	@NotEmpty(message = "mat khau khong duoc de trong")
	private String password;
}
