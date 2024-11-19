package com.hyul.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.hyul.model.MemberDAO;
import com.hyul.model.MemberDTO;
import com.hyul.model.MemberService;

public class MemberController extends HttpServlet {
	MemberService memberService = new MemberService();
	Map<String, String[]> map;

	String rstMsg;
	String command;
	MemberDAO memberDAO;
	MemberDTO memberDTO;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		doPost(req, rep);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		HttpSession session;
		command = req.getPathInfo();

		map = req.getParameterMap();

		boolean chkRst;

		switch (command) {
		
		// 회원 가입
		case "/join":
			chkRst = memberService.memberJoin(map);
			if (chkRst) {
				rstMsg = "회원가입 성공";
			} else {
				rstMsg = "회원가입 실패";
			}
			System.out.println(rstMsg);
			rep.sendRedirect("/JP001_hyul/main.jsp");
			break;

		// 아이디 찾기
		case "/find-id":
			// req 인코딩 방식 지정
			req.setCharacterEncoding("utf-8");
			
			// xhr 헤더 파라미터 읽기
			String mem_name = req.getParameter("mem_name");
			String mem_email = req.getParameter("mem_email");
			
			// 테스트용 출력
			System.out.println(mem_name);
			System.out.println(mem_email);
			
			JSONObject rstFindId = memberService.memberFindId(mem_name, mem_email);
			
			// json 전송
			rep.setContentType("application/json");
			rep.setCharacterEncoding("utf-8");
			
			rep.getWriter().write(rstFindId.toString());
			
			break;

		// 비밀번호 찾기
		case "/find-pw":
			// req 인코딩 방식 지정
			req.setCharacterEncoding("utf-8");
			
			// xhr 헤더 파라미터 읽기
			String mem_id = req.getParameter("mem_id");
			String mem_email2 = req.getParameter("mem_email");
			
			// 테스트용 출력
			System.out.println(mem_id);
			System.out.println(mem_email2);
			
			JSONObject rstFindPw = memberService.memberFindPw(mem_id, mem_email2);
			
			// json 전송
			rep.setContentType("application/json");
			rep.setCharacterEncoding("utf-8");
			
			rep.getWriter().write(rstFindPw.toString());
			
			break;

		// 로그인
		case "/login":
			memberDTO = memberService.memberLogin(map);
			session = req.getSession();

			if (memberDTO != null) {
				rstMsg = "로그인 성공";
				session.setAttribute("curUserId", memberDTO.getMem_id());
				session.setAttribute("curUserName", memberDTO.getMem_name());
				rep.sendRedirect("/JP001_hyul/main.jsp");
			} else {
				rstMsg = "로그인 실패";
				rep.sendRedirect("/JP001_hyul/resources/jsp/member-login.jsp");
				session.setAttribute("loginFail", "true");
			}

			System.out.println(rstMsg);

			break;

		// 로그아웃
		case "/logout":
			System.out.println("logout 요청 발생");

			session = req.getSession();
			session.removeAttribute("curUserId");
			session.removeAttribute("curUserName");

			rep.sendRedirect("/JP001_hyul/main.jsp");
			break;

		// 회원 정보 확인
		case "/info":
			System.out.println("info 요청 발생");
			session = req.getSession();
			String curUserId = (String) session.getAttribute("curUserId");
			memberDAO = MemberDAO.getInstance();
			memberDTO = memberDAO.selMember(curUserId);
			req.setAttribute("memberDTO", memberDTO);
			req.getRequestDispatcher("/resources/jsp/member-info.jsp").forward(req, rep);
			break;

		// 회원 정보 수정
		case "/update":
			memberService.memberUpd(map);
			
			session = req.getSession();
			session.setAttribute("curUserName", (String) map.get("mem_name")[0]);
			
			rep.sendRedirect("/JP001_hyul/resources/jsp/member-info.jsp");
			
			break;

		// 회원 삭제
		case "/delete":
			System.out.println("delete 요청 발생");
			boolean chk = memberService.memberDel(map);
			
			System.out.println("delete 요청 : " + chk); 
			
			session = req.getSession();
			session.removeAttribute("curUserId");
			session.removeAttribute("curUserName");

			rep.sendRedirect("/JP001_hyul/main.jsp");
			break;
		}
	}
}
