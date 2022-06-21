package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
@Table(name="Taco_Order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date placeAt;
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
	@ManyToMany(targetEntity = Taco.class)
	private List<Taco> tacos;
	@PrePersist
	public void createAt() {
		this.placeAt=new Date();
	}
	
}