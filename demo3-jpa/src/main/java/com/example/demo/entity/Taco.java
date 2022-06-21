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
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Table(name = "Taco")
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Taco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date createDate;
	@Size(min=1, message = "you must be select at least one ingredient")
	@ManyToMany(targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;
	@PrePersist
	void CreateDate() {
		this.createDate=new Date();
	}
}
