package com.example.demo.entity;

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
@Entity
@Table(name = "product")
public class product {
	@NotEmpty(message = "ma san pham khong duoc phep null")
	@Pattern(regexp = "[1-9a-zA-Z]*", message = "ma san pham chi gom cac ki tu tu chu va so")
	@Id
	private String code;
	@NotEmpty(message = "khong null")
	private String description;
	@NotNull(message = "khong empty")
	private double price;
}
