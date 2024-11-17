package com.hyul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hyul.util.DbClose;

public class SajuDAO {
	public static SajuDAO instance;
	
	public static SajuDAO getInstance() {
		if (instance == null) {
			instance = new SajuDAO();
		}
		return instance;
	}
	
	private Context init;
	private DataSource ds;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;

	private SajuDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  
	 */
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
