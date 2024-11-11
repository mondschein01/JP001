package com.hyul.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyul.model.BoardService;

@WebServlet("/board")
public class BoardController {
	// 게시판 모드 : 게시글 조회, 새 글쓰기 가능
	public void viewBoardList(HttpServletRequest req, HttpServletResponse res) {
		BoardService service_board = new BoardService();
		// 게시글 번호가 기본 키, 
	}
	
	// 조회 모드 : 수정, 삭제, 목록
	public void viewBoardContent(HttpServletRequest req, HttpServletResponse res) {
		
	}

	public void writeBoardContent(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void updateBoardContent(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	public void deleteBoardContent(HttpServletRequest req, HttpServletResponse res) {
		
	}
	

	
}
