package com.example.demo.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	@GetMapping
	public String Login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@PostMapping("/login")
	public String processLogin(Model model, @Valid @ModelAttribute User u,
			BindingResult bindingResult, HttpSession session,
			@PathParam("username") String username) {
		System.out.println(username);
		if(bindingResult.hasErrors()) {
			model.addAttribute("user", u);
			return "login";
		}else {
			User target = userService.getById(u.getUsername());
			if(target!=null&&target.getPassword().equals(u.getPassword())) {
				session.setAttribute("user", u);
				return "home";

			} else {
				model.addAttribute("user", u);
				return "login";
			}
		}
		
		
	}
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
		
	}
}
