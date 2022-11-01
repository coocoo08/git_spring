package kr.co.work;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class TransactionTest {

	@Autowired
	DataSource ds;
	
	@Test
	public void transactionTest() throws SQLException {
		
		Connection conn = null;
		try {
			deleteAll();
			conn = ds.getConnection();
			//conn.setAutoCommit(false);
			conn.setAutoCommit(true);
			
			String sql = "INSERT INTO t_user VALUES(?, ?, ?, ?, ?, ?, now())";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "ezen1");
			pstmt.setString(2, "0111");
			pstmt.setString(3, "ezen1");
			pstmt.setString(4, "ezen1@gmail.com");
			pstmt.setDate(5, new java.sql.Date(new Date().getTime()));
			pstmt.setString(6, "fb");
			
			int rowCnt = pstmt.executeUpdate();
			
			//pstmt.setString(1, "ezen3");
			pstmt.setString(1, "ezen1");
			rowCnt = pstmt.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		
	}

	private void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "delete from t_user";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}
}
