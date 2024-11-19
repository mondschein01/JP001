package com.hyul.model;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

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
	public JSONObject memberFindId(String mem_name, String mem_email) {
		// DB에서 입력 받은 값과 일치하는 DTO를 받아옴
		MemberDTO memberDTO = memberDAO.selMemberFindId(mem_name, mem_email);
		
		Map<String, String> tmpMap = new HashMap<>();
		
		// 일치하는 값이 있는지 체크
		if (memberDTO == null) {
			System.out.println("아이디 찾기 실패");
			tmpMap.put("rst", "가입된 아이디가 없습니다.");

		}
		// 일치하는 값이 있다면
		else {
			System.out.println("아이디 찾기 성공");
			String findId = memberDTO.getMem_id();
			tmpMap.put("rst", "가입된 아이디는 " + findId + " 입니다.");
		}

		// 결과 반환을 위한 JsonObejct 생성
		JSONObject rst = new JSONObject(tmpMap);
		
		return rst;
	}

	// 비밀번호 찾기
	public JSONObject memberFindPw(String mem_id, String mem_email) {
		// DB에서 입력 받은 값과 일치하는 DTO를 받아옴
		MemberDTO memberDTO = memberDAO.selMemberFindPw(mem_id, mem_email);

		Map<String, String> tmpMap = new HashMap<>();
		
		// 일치하는 값이 있는지 체크
		if (memberDTO == null) {
			System.out.println("비밀번호 찾기 실패");
			tmpMap.put("rst", "가입된 아이디가 없습니다.");

		}
		// 일치하는 값이 있다면
		else {
			System.out.println("비밀번호 찾기 성공");
			String findPw = memberDTO.getMem_pw();
			tmpMap.put("rst", "비밀번호는 " + findPw + " 입니다.");
		}

		// 결과 반환을 위한 JsonObejct 생성
		JSONObject rst = new JSONObject(tmpMap);
		
		return rst;
	}

	// 로그인
	public MemberDTO memberLogin(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];
		
		MemberDTO memberDTO = null;
		
		// 아이디 유무 체크
		memberDTO = memberDAO.selMember(userInputId);
		if (memberDTO != null) {
			// 비밀번호 체크
			String pwInDB = memberDTO.getMem_pw();
			if (userInputPw.equals(pwInDB)) {
				memberDTO.getMem_name();
			}
		}
		
		return memberDTO;
	}

	// 회원 수정
	public boolean memberUpd(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];
		userInputPw = map.get("mem_pw")[0];
		userInputName = map.get("mem_name")[0];
		userInputBirth = map.get("mem_birth")[0];
		userInputGender = map.get("mem_gender")[0];
		userInputEmail = map.get("mem_email")[0];
		
		boolean rst = false;

		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);

		// 회원 수정
		if (memberDTO != null) {
			String queryString = "UPDATE member SET " 
					+ "mem_pw = ?, " 
					+ "mem_name= ?, " 
					+ "mem_email = ?, "
					+ "mem_gender = ?, " 
					+ "mem_birth = ? "
					+ "WHERE mem_id = ?";
			
			memberDAO.insDelUpdMember(queryString, 
					userInputPw, 
					userInputName, 
					userInputEmail, 
					userInputGender,
					userInputBirth, 
					userInputId);

			rst = true;
		}

		return rst;
	}

	// 회원 삭제
	public boolean memberDel(Map<String, String[]> map) {
		userInputId = map.get("mem_id")[0];

		boolean rst = false;

		// 아이디 유무 체크
		MemberDTO memberDTO = memberDAO.selMember(userInputId);

		// 회원 삭제
		if (memberDTO != null) {
			String queryString = "DELETE FROM member " 
										+ "WHERE mem_id = ?";

			memberDAO.insDelUpdMember(queryString, userInputId);

			rst = true;
		}

		return rst;
	}

}
