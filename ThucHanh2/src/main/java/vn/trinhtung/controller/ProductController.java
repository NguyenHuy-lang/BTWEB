package vn.trinhtung.controller;

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

import lombok.RequiredArgsConstructor;
import vn.trinhtung.entity.Product;
import vn.trinhtung.service.ProductService;
import vn.trinhtung.validator.ProductValidator;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;
	private final ProductValidator productValidator;

	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("products", productService.getAll());
		return "products";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("action", "create");
		model.addAttribute("product", new Product());
		return "product";
	}

	@PostMapping("/create")
	public String processCreate(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
		productValidator.validate(product, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("action", "create");
			model.addAttribute("product", product);
			return "product";
		}
		productService.save(product);
		return "redirect:/products";
	}

	@GetMapping("/edit/{code}")
	public String edit(Model model, @PathVariable String code) {
		model.addAttribute("action", "edit");
		model.addAttribute("product", productService.getByCode(code));
		return "product";
	}

	@PostMapping("/edit")
	public String processEdit(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("action", "edit");
			model.addAttribute("product", product);
			return "product";
		}
		productService.save(product);
		return "redirect:/products";
	}

	@GetMapping("/confirm-delete/{code}")
	public String delete(Model model, @PathVariable String code) {
		model.addAttribute("product", productService.getByCode(code));
		return "confirm-delete";
	}

	@PostMapping("/delete")
	public String processDelete(@RequestParam String code) {
		productService.delete(code);
		return "redirect:/products";
	}
}
