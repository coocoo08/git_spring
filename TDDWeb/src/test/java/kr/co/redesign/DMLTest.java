package kr.co.redesign;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DMLTest {
	
	@Autowired
	DataSource ds;
	
	@Test
	public void springJdbcConnTest() throws SQLException {
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
		assertTrue(conn != null);
	}
	
	@Test
	public void insertUserTest() throws SQLException {
		User user = new User("ezen", "0111", "ezen student", "ezen@gmail.com", new Date(), "facebook", new Date());
		deleteAll();
		int rowCnt = insertUser(user);
		
		assertTrue(rowCnt==1);
	}
	
	private void deleteAll() throws SQLException {
		Connection conn = ds.getConnection();
		String sql = "delete from t_user";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
	}

	//사용자 정보를 t_user 테이블에 저장하는 메서드
	public int insertUser(User user) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "insert into t_user values (?, ?, ?, ?, ?, ?, now())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(6, user.getSns());
		
		int rowCnt = pstmt.executeUpdate();		//insert, update, delete
		
		return rowCnt;
	}
	
	@Test
	public void selectUserTest() throws SQLException {
		deleteAll();
		User user = new User("ezen", "0111", "ezen student", "ezen@gmail.com", new Date(), "facebook", new Date());
		int rowCnt = insertUser(user);
		User user2 = selectUser("ezen");
		
		assertTrue(user.getId().equals("ezen"));
	}
	
	public User selectUser(String id) throws SQLException {
		
		Connection conn = ds.getConnection();
		
		String sql = "select * from t_user where id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();		//select
		
		if (rs.next()) {
			User user = new User();
			user.setId(rs.getString(1));
			user.setPwd(rs.getString(2));
			user.setName(rs.getString(3));;
			user.setEmail(rs.getString(4));
			user.setBirth(new Date(rs.getDate(5).getTime()));
			user.setSns(rs.getString(6));
			user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
		}
		return null;
		
	}
}
