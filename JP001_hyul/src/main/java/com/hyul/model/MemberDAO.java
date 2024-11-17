package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hyul.util.DbClose;

public class MemberDAO {
	// 싱글톤
	public static MemberDAO instance;

	// 커넥션 풀
	private Context init; // JNDI의 기본 클래스 네이밍 컨텍스트의 루트 역할 // 데이터 소스나 환경 설정을 찾기 위해 사용
	private DataSource ds; //
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private MemberDTO memberDTO;
	private List<MemberDTO> aryMemberDTO;

	//
	private String mem_id, mem_pw, mem_name, mem_email, mem_gender, mem_birth;

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	private MemberDAO() {
		try {
			// InitialContext는 JNDI의 기본 네임스페이스, 네이밍 서비스와 관련된 자원을 찾고 사용할 수 있게 해줌
			init = new InitialContext(); //
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insDelUpdMember(String queryString, Object... data) {
		int su = 0;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			int paramIdx = 1;

			for (Object datum : data) {
				if (datum instanceof String) {
					pstmt.setString(paramIdx++, (String) datum);
				} else if (datum instanceof Integer) {
					pstmt.setInt(paramIdx++, (Integer) datum);
				} else if (datum instanceof Float) {
					pstmt.setFloat(paramIdx++, (Float) datum);
				} else if (datum instanceof Timestamp) {
					pstmt.setTimestamp(paramIdx++, (Timestamp) datum);
				} else {
					throw new IllegalArgumentException("지원하지 않거나 부정확한 데이터 타입임");
				}
			}
			su = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(pstmt, conn);
		}
		return su;
	}

	// return all
	public List<MemberDTO> selMember() {
		memberDTO = null;

		aryMemberDTO.clear();

		String queryString = "SELECT * FROM member";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem_id = rs.getString("mem_id");
				mem_pw = rs.getString("mem_pw");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				mem_gender = rs.getString("mem_gender");
				mem_birth = rs.getString("mem_birth");

				memberDTO = new MemberDTO();

				memberDTO.setMem_id(mem_id);
				memberDTO.setMem_pw(mem_pw);
				memberDTO.setMem_name(mem_name);
				memberDTO.setMem_email(mem_email);
				memberDTO.setMem_gender(mem_gender);
				memberDTO.setMem_birth(mem_birth);

				aryMemberDTO.add(memberDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return aryMemberDTO;
	}

	// return one
	public MemberDTO selMember(String _userInputId) {
		memberDTO = null;

		String queryString = "SELECT * FROM member" + " WHERE mem_id = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			pstmt.setString(1, _userInputId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem_id = rs.getString("mem_id");
				mem_pw = rs.getString("mem_pw");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				mem_gender = rs.getString("mem_gender");
				mem_birth = rs.getString("mem_birth");

				memberDTO = new MemberDTO();

				memberDTO.setMem_id(mem_id);
				memberDTO.setMem_pw(mem_pw);
				memberDTO.setMem_name(mem_name);
				memberDTO.setMem_email(mem_email);
				memberDTO.setMem_gender(mem_gender);
				memberDTO.setMem_birth(mem_birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return memberDTO;
	}

	// return one
	public MemberDTO selMemberFindId(String _userInputName, String _userInputEmail) {
		memberDTO = null;

		String queryString = "SELECT * FROM member " + "WHERE mem_name = ? AND mem_email = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			pstmt.setString(1, _userInputName);
			pstmt.setString(2, _userInputEmail);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem_id = rs.getString("mem_id");
				mem_pw = rs.getString("mem_pw");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				mem_gender = rs.getString("mem_gender");
				mem_birth = rs.getString("mem_birth");

				memberDTO = new MemberDTO();

				memberDTO.setMem_id(mem_id);
				memberDTO.setMem_pw(mem_pw);
				memberDTO.setMem_name(mem_name);
				memberDTO.setMem_email(mem_email);
				memberDTO.setMem_gender(mem_gender);
				memberDTO.setMem_birth(mem_birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return memberDTO;
	}

	// return one
	public MemberDTO selMemberFindPw(String _userInputId, String _userInputEmail) {
		memberDTO = null;

		String queryString = "SELECT * FROM member " + "WHERE mem_id = ? AND mem_email = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			pstmt.setString(1, _userInputId);
			pstmt.setString(2, _userInputEmail);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem_id = rs.getString("mem_id");
				mem_pw = rs.getString("mem_pw");
				mem_name = rs.getString("mem_name");
				mem_email = rs.getString("mem_email");
				mem_gender = rs.getString("mem_gender");
				mem_birth = rs.getString("mem_birth");

				memberDTO = new MemberDTO();

				memberDTO.setMem_id(mem_id);
				memberDTO.setMem_pw(mem_pw);
				memberDTO.setMem_name(mem_name);
				memberDTO.setMem_email(mem_email);
				memberDTO.setMem_gender(mem_gender);
				memberDTO.setMem_birth(mem_birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return memberDTO;
	}

}
