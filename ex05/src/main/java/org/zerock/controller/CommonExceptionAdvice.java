package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex){
		
		logger.info(ex.toString());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error/error_common");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
		
	}

}
