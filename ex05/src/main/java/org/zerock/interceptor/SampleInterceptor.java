package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("pre Handle...................................");
		
		HandlerMethod method = (HandlerMethod) handler;
		
		logger.info("Bean : {} ", method.getBean());
		logger.info("Method : {} ", method.getMethod());
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {

		logger.info("post Handle..................................");
		
		Object result = mav.getModel().get("result");
		logger.info("result : " + result);
		
		if(result != null){
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
		
	}

}
