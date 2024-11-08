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

import com.hyul.util.DbClose;
import com.hyul.util.DbSet;

public class DAO_hyul {

	// create // 미구현
	public void insHyul() {
		
	}

	// read
	public List<DTO_hyul> selHyul() {
		List<DTO_hyul> dtoAry_hyul = new ArrayList<>();

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

				DTO_hyul tmpDTO = new DTO_hyul();

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

	public DTO_hyul selHyul(String _category, String _hyulName) {
		Connection conn = DbSet.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DTO_hyul tmpDTO = null;

		try {
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

				tmpDTO = new DTO_hyul();

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
	public void updHyul(DTO_hyul _dto) {
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
				pstmt.setString(1, "./src/main/webapp/img/map/" + category2 + "/" + hyulName2 + ".png");
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
		List<DTO_hyul> dtos = selHyul();
		
		for (int i = 0; i < dtos.size(); i++) {
			updHyul(dtos.get(i));
		}
	}
}
