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
	
	//@Test
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
		
		// 입력값에 사용된 물음표(?)를 인파라미터라고 함.
		// 정확한 값을 나중에 채워주겠다는 뜻임.
		String sql = "insert into t_user values (?, ?, ?, ?, ?, ?, now())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		// 인파라미터 설정 시 데이터 타입에 맞는 set메서드를 사용함
		// set메서드는 데이터 타입별로 다양하게 준비되어 있음
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(6, user.getSns());
		
		int rowCnt = pstmt.executeUpdate();		//insert, update, delete
		
		return rowCnt;
	}
	
	//@Test
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
	
	@Test
	public void deleteUserTest() throws SQLException {
		deleteAll();
		int rowCnt = deleteUser("ezen4");
		assertTrue(rowCnt == 0);
		
		User user = new User("ezen", "0111", "ezen2", "ezen@gmail.com", new Date(), "facebook", new Date());
		rowCnt = insertUser(user);
		assertTrue(rowCnt == 1);
		
		deleteUser(user.getId());
		assertTrue(rowCnt == 1);
		
		assertTrue(selectUser(user.getId())==null);
	}
	
	public int deleteUser(String id) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "delete from t_user where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
//		int rowCnt= pstmt.executeUpdate();
//		return rowCnt;
		return pstmt.executeUpdate();
	}
	
	@Test
	public void updateUserTest() throws SQLException {
		deleteAll();
		User user = new User("ezen5", "0111", "ezen2", "ezen@gmail.com", new Date(), "facebook", new Date());
		int rowCnt = insertUser(user);
		assertTrue(rowCnt == 1);

		user.setPwd("0112");
		user.setEmail("ezen@gmail.com");
		rowCnt = updateUser(user);
		assertTrue(rowCnt == 1);
		
//		User user2 = selectUser(user.getId());
//		System.out.println("user = " + user);
//		System.out.println("user = " + user2);
//		assertTrue(user.equals(user2));
	}
	
	// 매개변수로 받은 사용자 정보로 t_user 테이블을 update하는 메서드
	public int updateUser(User user) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sql = "update t_user set \r\n"
				+ "pwd = ?, \r\n"
				+ "name = ?, \r\n"
				+ "email = ?,\r\n"
				+ "birth = ?, \r\n"
				+ "sns = ?, \r\n"
				+ "reg_date = ? \r\n"
				+ "where id = ?";
//		String sql = "update t_user set values (?, ?, ?, ?, ?, ?, now())";
//		String sql = "update t_user set name = ? where id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, user.getId());
		pstmt.setString(1, user.getPwd());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getEmail());
		pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
		pstmt.setString(5, user.getSns());
		pstmt.setDate(6, new java.sql.Date(0));
		pstmt.setString(7,user.getId());
		
		int rowCnt = pstmt.executeUpdate();
		return rowCnt;
	}
}
