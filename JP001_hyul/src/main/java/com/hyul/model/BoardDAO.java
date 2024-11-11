package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hyul.util.DbClose;
import com.hyul.util.DbSet;

public class BoardDAO {
	public List<BoardDTO> selBoard() {
		List<BoardDTO> dtoAry_board = new ArrayList<>();

		Connection conn = DbSet.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM board";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String bIdx = rs.getString("bIdx");
				String bTitle = rs.getString("bTitle");
				String bWriter = rs.getString("bWriter");
				String bRegTime = rs.getString("bRegTime");
				String bHits = rs.getString("bHits");
				String bContent = rs.getString("bContent");

				BoardDTO tmpDTO = new BoardDTO();

				tmpDTO.setbIdx(bIdx);
				tmpDTO.setbTitle(bTitle);
				tmpDTO.setbWriter(bWriter);
				tmpDTO.setbRegTime(bRegTime);
				tmpDTO.setbHits(bHits);
				tmpDTO.setbContent(bContent);

				dtoAry_board.add(tmpDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return dtoAry_board;
	}
}
