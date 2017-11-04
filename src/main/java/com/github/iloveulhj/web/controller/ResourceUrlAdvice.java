package com.github.iloveulhj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@ControllerAdvice("com.github.iloveulhj.web.controller")
public class ResourceUrlAdvice {
	@Autowired
	private ResourceUrlProvider resourceUrlProvider;

	@ModelAttribute("resourceUrlProvider")
	public ResourceUrlProvider urls() {
		return this.resourceUrlProvider;
	}
}
