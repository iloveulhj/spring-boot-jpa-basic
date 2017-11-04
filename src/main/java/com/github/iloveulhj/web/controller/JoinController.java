package com.github.iloveulhj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Controller
@RequestMapping("")
public class JoinController {
	@GetMapping(path = {"/join"})
	public String join(Model model) {
		model.addAttribute("a", new ResourceUrlProvider());
		return "join";
	}
}
