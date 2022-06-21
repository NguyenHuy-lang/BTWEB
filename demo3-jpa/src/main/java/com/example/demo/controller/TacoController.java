package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Taco;
import com.example.demo.service.TacoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class TacoController {
	private final TacoService tacoService;
	@PostMapping("/save")
	public String save(@ModelAttribute Taco t) {
		tacoService.save(t);
		return "redirect:/ingredient";
	}
}
