package com.hyul.model;

import java.util.Map;

public class MemberService {
	MemberDAO memberDAO;

	String userInputId, userInputPw, userInputName, userInputEmail, userInputGender, userInputBirth;

	// 생성자
	public MemberService() {
		memberDAO = MemberDAO.getInstance();
	}

	// 회원 가입
	public boolean memberJoin(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];
		userInputName = map.get("mem_name")[0];
		userInputEmail = map.get("mem_email")[0];
		userInputGender = map.get("mem_gender")[0];
		userInputBirth = map.get("mem_birth")[0];

		boolean rst = false;
		
		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);

		// 중복 아이디 없을 시, 회원가입
		if (memberDTO == null) {
			String queryString = "INSERT INTO member" + " VALUES (?, ?, ?, ?, ?, ?)";

			memberDAO.insDelUpdMember(queryString, userInputId, userInputPw, userInputName, userInputEmail,
					userInputGender, userInputBirth);

			rst = true;
		}

		return rst;
	}

	// 아이디 찾기
	public String memberFindId(Map<String, String[]> map) {
		// 회원으로부터 이름과 이메일을 입력 받음
		userInputName = map.get("mem_name")[0];
		userInputEmail = map.get("mem_email")[0];

		// DB에서 입력 받은 값과 일치하는 DTO를 받아옴
		MemberDTO memberDTO = memberDAO.selMemberFindId(userInputName, userInputEmail);

		// 일치하는 값이 있는지 체크
		if (memberDTO == null) {
			System.out.println("아이디 찾기 실패");

			return null;
		}

		// 일치하는 값이 있다면
		String findId = memberDTO.getMem_id();
		System.out.println(findId + "아이디 찾기 성공");

		return findId;
	}

	// 비밀번호 찾기
	public String memberFindPw(Map<String, String[]> map) {
		// 회원으로부터 이름과 이메일을 입력 받음
		userInputId = map.get("mem_id")[0];
		userInputEmail = map.get("mem_email")[0];

		// DB에서 입력 받은 값과 일치하는 DTO를 받아옴
		MemberDTO memberDTO = memberDAO.selMemberFindPw(userInputId, userInputEmail);

		// 일치하는 값이 있는지 체크
		if (memberDTO == null) {
			System.out.println("비밀번호 찾기 실패");

			return null;
		}

		// 일치하는 값이 있다면
		String findPw = memberDTO.getMem_pw();
		System.out.println(findPw + "비밀번호 찾기 성공");

		return findPw;
	}

	// 로그인
	public boolean memberLogin(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];

		boolean rst = false;

		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);
		if (memberDTO != null) {
			// 비밀번호 체크
			String pwInDB = memberDTO.getMem_pw();
			if (userInputPw.equals(pwInDB)) {
				rst = true;
			}
		}
		return rst;
	}

	// 회원 수정
	public boolean memberUpd(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];
		userInputName = map.get("mem_name")[0];
		userInputEmail = map.get("mem_email")[0];
		userInputGender = map.get("mem_gender")[0];
		userInputBirth = map.get("mem_birth")[0];

		boolean rst = false;

		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);

		// 회원 수정
		if (memberDTO != null) {
			String queryString = "UPDATE member SET " + "mem_pw = ? " + "mem_name= ? " + "mem_email = ? "
					+ "mem_gender = ? " + "mem_birth = ? " + "WHERE mem_id = ?";

			memberDAO.insDelUpdMember(queryString, userInputPw, userInputName, userInputEmail, userInputGender,
					userInputBirth, userInputId);

			rst = true;
		}

		return rst;
	}

	// 회원 삭제
	public boolean memberDel(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];
		userInputName = map.get("mem_name")[0];
		userInputEmail = map.get("mem_email")[0];
		userInputGender = map.get("mem_gender")[0];
		userInputBirth = map.get("mem_birth")[0];

		boolean rst = false;

		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);

		// 회원 삭제
		if (memberDTO == null) {
			String queryString = "DELETE FROM member " + "WHERE mem_id = ?";

			memberDAO.insDelUpdMember(queryString, userInputId);

			rst = true;
		}

		return rst;
	}

}
