package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Entity
public class Product {
	@Pattern(regexp="[0-9a-zA-Z]*" ,message="ma chi gom chu va so")
	@NotEmpty(message = "Ma san pham khong duoc null")
	@Id
	private String code;
	@NotEmpty(message = "mieu ta san pham khong duoc null")
	private String description;
	@NotNull(message = "gia san pham khong duoc null")
	private double price;
}
