package com.raza.inventory.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.raza.inventory.exceptions.MicroServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MicroServiceException.class)
	public ModelAndView handleAllException(Exception exception) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorMessage", exception.getMessage());
		return mv;
	}
}
