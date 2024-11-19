package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hyul.util.DbClose;

public class KeywordDAO {
public static KeywordDAO instance;
	
	public static KeywordDAO getInstance() {
		if (instance == null) {
			instance = new KeywordDAO();
		}
		return instance;
	}
	
	private Context init;
	private DataSource ds;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;

	private KeywordDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 인기키워드 다섯 개
	public String[] getHyulKeyword() {
		String[] rst = new String[5];
		
		String queryString = "SELECT * FROM ("
				+ "SELECT * FROM hyulEffect ORDER BY DBMS_RANDOM.RANDOM"
				+ ") "
				+ "WHERE rownum <= 5";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);

			rs = pstmt.executeQuery();

			int i = 0;
			
			while (rs.next()) {
				String hyulEffect = rs.getString("hyulEffect");
				
				rst[i++] = hyulEffect;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return rst;
	}
	
	// 효과 검색
	public ArrayList<MapDTO> getHyulEffectQuery(String q) {
		ArrayList<MapDTO> list_mapDTO = new ArrayList<>();
		
		String queryString = "SELECT * FROM hyulMap WHERE hyulEffect LIKE ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(queryString);
			pstmt.setString(1, "%" + q + "%");

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String category = rs.getString("category");
				String hyulName = rs.getString("hyulName");
				String hyulPos = rs.getString("hyulPos");
				String hyulSelect = rs.getString("hyulSelect");
				String wayToChim = rs.getString("wayToChim");
				String hyulEffect = rs.getString("hyulEffect");
				String imgPath = rs.getString("imgPath");

				MapDTO tmpDTO = new MapDTO();

				tmpDTO.setCategory(category);
				tmpDTO.setHyulName(hyulName);
				tmpDTO.setHyulPos(hyulPos);
				tmpDTO.setHyulSelect(hyulSelect);
				tmpDTO.setWayToChim(wayToChim);
				tmpDTO.setHyulEffect(hyulEffect);
				tmpDTO.setImgPath(imgPath);

				list_mapDTO.add(tmpDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}

		return list_mapDTO;
	}
		
		
}
