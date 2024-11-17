package com.hyul.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.hyul.model.MapService;

//@WebServlet("/map")
public class MapController extends HttpServlet{
	@Override
	public void init() {
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep) 
			throws ServletException, IOException {
		doHandle(req, rep);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) 
			throws ServletException, IOException {
		doHandle(req, rep);
	}
	
	@Override
	public void destroy() {
		
	}
	
	
	public void doHandle(HttpServletRequest req, HttpServletResponse rep) 
			throws ServletException, IOException  {
		// req 인코딩 방식 지정
		req.setCharacterEncoding("utf-8");
		
		// xhr 헤더 파라미터 읽기
		String cName = req.getParameter("cName");
		String hName = req.getParameter("hName");
		
		// "^[ㄱ-ㅎ|가-힣]*$"
		hName = hName.replaceAll("[^가-힣]", "");
		
		// 테스트용 출력
//		System.out.println(cName);
//		System.out.println(hName);
		
		// 결과를 얻기 위한 readHyulMapData 메소드 실행
		MapService obj = new MapService();
		JSONObject jo = obj.readHyulMapData(cName, hName);
		
		// json 쓰기
		rep.setContentType("application/json");
		rep.setCharacterEncoding("utf-8");
		
		rep.getWriter().write(jo.toString());
		
	}
	
}
