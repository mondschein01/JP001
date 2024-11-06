package com.hyul.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hyulDict")
public class Controller_hyul {
	public void dd(HttpServletRequest req, HttpServletResponse res) {
		// request로부터 매개변수 2개가 건너옴
		req.getAttribute(""); // 
		req.getAttribute(""); // 
		
	}
}
