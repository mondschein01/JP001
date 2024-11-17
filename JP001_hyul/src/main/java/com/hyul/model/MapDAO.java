package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hyul.util.DbClose;
import com.hyul.util.DbSet;

public class MapDAO {
	// constructor for connection pool
	private Context init;
	private DataSource ds;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private MapDTO tmpDTO;
	
	private MapDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");
			setHyulImgPath();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// singleton pattern
	private static MapDAO instance;

	public static MapDAO getInstance() {
		if (instance == null) {
			instance = new MapDAO();
		}
		return instance;
	}
	
	// create // 미구현
	public void insHyul() {
		
	}

	// read
	public List<MapDTO> selHyul() {
		List<MapDTO> dtoAry_hyul = new ArrayList<>();

		Connection conn = DbSet.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM hyulmap";

			pstmt = conn.prepareStatement(sql);

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

				dtoAry_hyul.add(tmpDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return dtoAry_hyul;
	}

	public MapDTO selHyul(String _category, String _hyulName) {
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM hyulMap WHERE  category LIKE ? AND hyulname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + _category + "%");
			pstmt.setString(2, "%" + _hyulName + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String category = rs.getString("category");
				String hyulName = rs.getString("hyulName");
				String hyulPos = rs.getString("hyulPos");
				String hyulSelect = rs.getString("hyulSelect");
				String wayToChim = rs.getString("wayToChim");
				String hyulEffect = rs.getString("hyulEffect");
				String imgPath = rs.getString("imgPath");

				tmpDTO = new MapDTO();

				tmpDTO.setCategory(category);
				tmpDTO.setHyulName(hyulName);
				tmpDTO.setHyulPos(hyulPos);
				tmpDTO.setHyulSelect(hyulSelect);
				tmpDTO.setWayToChim(wayToChim);
				tmpDTO.setHyulEffect(hyulEffect);
				tmpDTO.setImgPath(imgPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return tmpDTO;
	}

	// update // 미구현
	public void updHyul() {
		
	}
	
	// update
	public void updHyul(MapDTO _dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql_update = "UPDATE hyulMap SET imgPath=? WHERE hyulName=?";

			conn = DbSet.getConnection();

			String category = _dto.getCategory();
			int length = category.length();
			String category2 = category.substring(length - 3, length - 1);

			String hyulName = _dto.getHyulName();
			Pattern pattern = Pattern.compile("\\b[a-zA-Z]{2}\\d+\\b");
			Matcher matcher = pattern.matcher(hyulName);
			String hyulName2 = null;
			if (matcher.find()) {
				hyulName2 = matcher.group();
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setString(1, "./../img/map/" + category2 + "/" + hyulName2.toLowerCase() + ".png");
				pstmt.setString(2, hyulName);
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(pstmt, conn);
		}
	}

	// delete // 미구현
	public void delHyul() {
		
	}

	// set ImgPath
	public void setHyulImgPath() {
		List<MapDTO> dtos = selHyul();
		
		for (int i = 0; i < dtos.size(); i++) {
			updHyul(dtos.get(i));
		}
	}
}
