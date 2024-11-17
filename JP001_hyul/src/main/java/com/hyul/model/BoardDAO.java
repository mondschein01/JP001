package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hyul.util.DbClose;

public class BoardDAO {
	// singleton
	private static BoardDAO instance;
	
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}

	// connection pool
	private Context init;
	private DataSource ds;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private BoardDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardDTO> getBoardDTOList() {
		List<BoardDTO> dtoAry_board = new ArrayList<>();

		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM board ORDER BY bd_idx DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int idx = rs.getInt("bd_idx");
				String title = rs.getString("bd_title");
				String writer = rs.getString("bd_writer");
				int hits = rs.getInt("bd_hits");
				String content = rs.getString("bd_content");
				Timestamp regTime = rs.getTimestamp("bd_regTime");

				BoardDTO tmpDTO = new BoardDTO();

				tmpDTO.setIdx(idx);
				tmpDTO.setTitle(title);
				tmpDTO.setWriter(writer);
				tmpDTO.setRegTime(regTime);
				tmpDTO.setHits(hits);
				tmpDTO.setContent(content);

				dtoAry_board.add(tmpDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return dtoAry_board;
	}
	
	public List<BoardDTO> getBoardDTOList(int _startNum, int _endNum) {
		List<BoardDTO> dtoAry_board = new ArrayList<>();

		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM board"
					+ " WHERE bd_idx BETWEEN ? AND ?"
					+ " ORDER BY bd_idx DESC";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _startNum);
			pstmt.setInt(2, _endNum);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = rs.getInt("bd_idx");
				String title = rs.getString("bd_title");
				String writer = rs.getString("bd_writer");
				int hits = rs.getInt("bd_hits");
				String content = rs.getString("bd_content");
				Timestamp regTime = rs.getTimestamp("bd_regTime");

				BoardDTO tmpDTO = new BoardDTO();

				tmpDTO.setIdx(idx);
				tmpDTO.setTitle(title);
				tmpDTO.setWriter(writer);
				tmpDTO.setRegTime(regTime);
				tmpDTO.setHits(hits);
				tmpDTO.setContent(content);

				dtoAry_board.add(tmpDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return dtoAry_board;
	}

	public BoardDTO getBoardDTO(int _idx) {
		BoardDTO tmpDTO = new BoardDTO();
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM board WHERE bd_idx = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, _idx);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = rs.getInt("bd_idx");
				String title = rs.getString("bd_title");
				String writer = rs.getString("bd_writer");
				int hits = rs.getInt("bd_hits");
				String content = rs.getString("bd_content");
				Timestamp regTime = rs.getTimestamp("bd_regTime");
				

				tmpDTO.setIdx(idx);
				tmpDTO.setTitle(title);
				tmpDTO.setWriter(writer);
				tmpDTO.setRegTime(regTime);
				tmpDTO.setHits(hits);
				tmpDTO.setContent(content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return tmpDTO;
	}
	
	public int getBoardRecordCount() {
		int numRecord = 0;
		
		try {
			String sql = "SELECT COUNT(*) FROM board";

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				numRecord = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbClose.close(rs, pstmt, conn);
		}
		return numRecord;
	}

	public int insDelUpdBoard(String sql, Object... data) {
		int su = 0;
	    try {
	        conn = ds.getConnection();

	        pstmt = conn.prepareStatement(sql);
	        
	        int paramIdx = 1; // SQL 매개변수 인덱스
	        
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
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DbClose.close(pstmt, conn);
	    }
	    return su;
	}
	
}
