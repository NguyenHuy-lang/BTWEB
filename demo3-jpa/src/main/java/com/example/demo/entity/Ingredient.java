package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Ingredient")
public class Ingredient {
	@Id
	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Type type;
	public static enum Type{
		WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
	}
	
}
