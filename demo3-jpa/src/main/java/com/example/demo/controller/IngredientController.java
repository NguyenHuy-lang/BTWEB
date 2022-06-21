package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Taco;
import com.example.demo.service.IngredientService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	private final IngredientService ingredientService;
	@GetMapping
	public String getAllIngredient(Model model) {
		List<Ingredient> v = ingredientService.getAll();
		ArrayList<String> type = new ArrayList<String>();
		type.add("WRAP");
		type.add("PROTEIN");
		type.add("VEGGIES");
		type.add("CHEESE");
		type.add("SAUCE");
		
		for(String t: type) {
			ArrayList<Ingredient> a = new ArrayList<>();
			for(Ingredient i : v) {
				if(i.getType().toString().toUpperCase().equals(t)) {
					a.add(i);
				}
			}
			model.addAttribute(t, a);
		}
		model.addAttribute("Taco", new Taco());
		return "ingredients";
	}
}
