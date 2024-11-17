package com.hyul.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hyul.model.MemberDAO;
import com.hyul.model.MemberDTO;
import com.hyul.model.MemberService;

public class MemberController extends HttpServlet {
	MemberService memberService = new MemberService();
	Map<String, String[]> map;

	String rstMsg;
	String command;

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
			rep.sendRedirect("./../jsp/home.jsp");
			break;

		// 아이디 찾기
		case "/find-id":
			String rstFindId = memberService.memberFindId(map);

			// 입력한 정보와 일치하는 아이디 없음
			if (rstFindId == null) {
				rep.sendRedirect("./../jsp/find-id.jsp");
			}
			// 입력한 정보와 일치하는 아이디 있음
			else {
				req.setAttribute("rstFindId", rstFindId);
				req.getRequestDispatcher("./../jsp/find-id.jsp").forward(req, rep);
			}

			break;

		// 비밀번호 찾기
		case "/find-pw":
			// 클라이언트로부터 post 방식으로 아이디와 이메일이 넘어옴
			String rstFindPw = memberService.memberFindPw(map);

			// 입력한 정보와 일치하는 비밀번호 없음
			if (rstFindPw == null) {
				rep.sendRedirect("./../jsp/find-pw.jsp");
			}
			// 입력한 정보와 일치하는 비밀번호 있음
			else {
				req.setAttribute("rstFindPw", rstFindPw);
				req.getRequestDispatcher("./../jsp/find-pw.jsp").forward(req, rep);
			}

			break;

		// 로그인
		case "/login":
			chkRst = memberService.memberLogin(map);
			if (chkRst) {
				rstMsg = "로그인 성공";
				session = req.getSession();
				session.setAttribute("curUserId", (String) map.get("mem_id")[0]);
			} else {
				rstMsg = "로그인 실패";
			}

			System.out.println(rstMsg);
			rep.sendRedirect("./../jsp/home.jsp");

			break;

		// 로그아웃
		case "/logout":
			rep.sendRedirect("/JP001_hyul/jsp/home.jsp");

			session = req.getSession();
			session.removeAttribute("curUserId");

			break;

		// 회원 정보 확인
		case "/info":
			session = req.getSession();
			String curUserId = (String) session.getAttribute("curUserId");
			MemberDAO memberDAO = MemberDAO.getInstance();
			MemberDTO memberDTO = memberDAO.selMember(curUserId);
			req.setAttribute("memberDTO", memberDTO);
			req.getRequestDispatcher("./../jsp/info.jsp").forward(req, rep);
			break;

		// 회원 정보 수정
		case "/update":
			memberService.memberUpd(map);
			break;

		// 회원 삭제
		case "/delete":
			memberService.memberDel(map);
			break;
		}
	}
}
