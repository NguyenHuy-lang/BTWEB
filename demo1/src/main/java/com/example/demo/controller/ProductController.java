package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.product;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	@GetMapping
	public String getAllProduct(Model model) {
		model.addAttribute("product", productService.getAll());
		return "products";
	}
	@GetMapping("/edit/{code}")
	public String editProduct(Model model, @PathVariable String code) {
		model.addAttribute("product", productService.getByCode(code));
		return "product-form";
	}
	@PostMapping("/edit")
	public String processEditProduct(Model model,@Valid @ModelAttribute product p ,BindingResult bindingResult) {
		System.out.println(p.getCode());
		if(bindingResult.hasErrors()) {
			model.addAttribute("product", p);
			return "product-form";
		}
		productService.save(p);
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{code}")
	public String deleteProduct(Model model, @PathVariable String code) {
		model.addAttribute("product", productService.getByCode(code));
		return "confirm-delete";
		
	}
	@PostMapping("/delete")
	public String processDelete(@RequestParam String code) {
		
		productService.delete(code);
		return "redirect:/products";
	}
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new product());
		return "product-add";
	}
	@PostMapping("/add")
	public String processAdd(Model model, @Valid @ModelAttribute product p, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("product", p);
			return "product-add";
		}
		productService.save(p);
		return "redirect:/products";
	}
	
}
