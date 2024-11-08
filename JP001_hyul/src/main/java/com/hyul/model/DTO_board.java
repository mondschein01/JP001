package com.hyul.model;

public class DTO_board {
	private String bIdx; // 글번호 Sequance
	private String bTitle; // 제목
	private String bWriter; // 글쓴이
	private String bRegTime; // 작성일
	private String bHits; // 조회수
	private String bContent; // 내용
	
	public String getbIdx() {
		return bIdx;
	}

	public void setbIdx(String bIdx) {
		this.bIdx = bIdx;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbRegTime() {
		return bRegTime;
	}

	public void setbRegTime(String bRegTime) {
		this.bRegTime = bRegTime;
	}

	public String getbHits() {
		return bHits;
	}

	public void setbHits(String bHits) {
		this.bHits = bHits;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
}
