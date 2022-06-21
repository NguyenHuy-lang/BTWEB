package com.example.demo.controller;

import javax.validation.Valid;

//import java.security.PublicKey;
//
//import javax.validation.Valid;
//
//import org.aspectj.weaver.NewConstructorTypeMunger;
//import org.hibernate.sql.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Product;
import com.example.demo.service.productService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	private final productService prdservice;
	
	@GetMapping	
	public String getAll(Model model) {
		model.addAttribute("products", prdservice.getAll());
		return "product";        
	}
	@GetMapping("/edit/{code}")
	public String edit(Model model, @PathVariable String code) {
		model.addAttribute("action", "edit");
		model.addAttribute("product", prdservice.getByCode(code));
		return "product-form";
		
	}
	
	@PostMapping("/edit")
	public String processEdit(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("action", "edit");
			model.addAttribute("product", product);
			return "product-form";
		}
		prdservice.save(product);
		return "redirect:/products";
	}
	@GetMapping("/confirm-delete/{code}")
	public String confim_Delete(Model model, @PathVariable String code){
		model.addAttribute("product", prdservice.getByCode(code));
		return "confirm-delete";
		
	}
	@PostMapping("/delete")
	public String delete(@RequestParam("code") String code){
		prdservice.delete(code);
		return "redirect:/products";
		
	}
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	@PostMapping("/create")
	public String processCreate(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("product", product);
			return "addProduct";
		}
		prdservice.save(product);
		return "redirect:/products";
	}
}
