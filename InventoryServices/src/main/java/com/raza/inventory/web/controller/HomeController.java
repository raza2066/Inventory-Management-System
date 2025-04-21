package com.raza.inventory.web.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
	@GetMapping(value = "welcome.html")
	public ModelAndView showHomePage() {
		LOGGER.info("Execution Started [Login()]");
		ModelAndView modelAndView = new ModelAndView("welcome");
		LOGGER.info("Execution Over [Login()]");
		return modelAndView;
	}
	
	@GetMapping(value = "accessDeniedPage.html")
	public ModelAndView showHomePage1() {
		LOGGER.info("Execution Started [Login()]");
		ModelAndView modelAndView = new ModelAndView("accessDeniedPage");
		LOGGER.info("Execution Over [Login()]");
		return modelAndView;
	}
}
