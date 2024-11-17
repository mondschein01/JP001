package com.hyul.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.hyul.model.SajuService;

@WebServlet("/saju")
public class SajuController extends HttpServlet{
	public SajuService sajuService;
	
	/**
	 * 사용자로부터 생년월일시 입력이 발생하면, 
	 * AJAX 방식으로 Json 형식의 데이터를 전달 받고
	 * 오행과 추천 혈자리를 service로 구한 뒤
	 * rep.getWriter().write(jo.toString());으로 전송하면
	 * 클라이언트의 JavaScript의 DOM을 이용해서
	 * Change text And Drawing Wuxing pentagon 
	 */
}
