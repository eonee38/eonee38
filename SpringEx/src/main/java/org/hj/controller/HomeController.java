package org.hj.controller;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)  // http://localhost:8080"/"
// 접근제어자  반환타입  메서드명(매개변수, 매개변수)
	public String home(Locale locale, Model model) { //home 메소드 실행
		return "home";	// /WEB-INF/views/home.jsp
	}
	@RequestMapping(value = "/drop", method = RequestMethod.GET)
	// 접근제어자  반환타입  메서드명(매개변수, 매개변수)
		public String drop() {
			return "drop";
		}
		
	
	
}
