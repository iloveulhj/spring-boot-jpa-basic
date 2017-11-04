package com.github.iloveulhj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MembersController {
	@GetMapping("/members")
	private String getMembers() {
		return "members";
	}
}
