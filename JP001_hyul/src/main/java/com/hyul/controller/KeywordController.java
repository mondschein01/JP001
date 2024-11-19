package com.hyul.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hyul.model.KeywordService;

@WebServlet("/keyword/*")
public class KeywordController extends HttpServlet {
	String rstMsg;
	String command;
	HttpSession session;
	KeywordService keywordService;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		doPost(req, rep);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		keywordService = new KeywordService();
		
		req.setCharacterEncoding("utf-8");
		
		command = req.getPathInfo();
		JSONObject jo;
		
		switch (command) {
		
		case "/get-keyword":
			System.out.println("get-keyword 요청 발생");
			jo = keywordService.getRecomKeyword();
			
			req.setAttribute("recommKeyword", jo);
			req.getRequestDispatcher("/resources/jsp/keyword.jsp").forward(req, rep);
			
			break;
			
		case "/query":
			System.out.println("query 요청 발생");
			String query = req.getParameter("q");
			if (query == null || query.isEmpty()) {
				System.out.println("입력 값 없음");
			}
			else {
				System.out.println(query);
				JSONArray joAry = keywordService.getQueryResult(req.getParameter("q"));
				
//				// json 쓰기
				rep.setContentType("application/json");
				rep.setCharacterEncoding("utf-8");
//				
				rep.getWriter().write(joAry.toString());
			}
			
			break;
		}
		
		
	}
	
}