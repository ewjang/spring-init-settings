package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/jsp")
public class JspController {
	
	@Operation(summary="default api", description="blank")
	@GetMapping("/jsp1")
	public ModelAndView jsp1 () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jsp/jsp1");
		mav.addObject("test", "jsp1");
		
		return mav;
	}
	
	
	@Operation(summary="default api", description="blank")
	@GetMapping("/jsp2")
	public ModelAndView jsp2 () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/jsp/jsp2");
		mav.addObject("test", "jps2");
		
		return mav;
	}
}
