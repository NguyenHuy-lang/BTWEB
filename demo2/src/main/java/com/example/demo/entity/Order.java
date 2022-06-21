package com.example.demo.entity;
import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
public class Order {
	@NotBlank(message = "Name is required")
	private String name;
	@NotBlank(message = "Street is required")
	private String street;
	@NotBlank(message = "city is required")
	private String city;
	@NotBlank(message = "state is required")
	private String state;
	@NotBlank(message = "zip is required")
	private String zip;
	@NotBlank(message = "ccNumber is required")
	private String ccNumber;
	@NotBlank(message = "ccExpiration is required")
	private String ccExpiration;
	@NotBlank(message = "ccCVV is required")
	private String ccCVV;
}