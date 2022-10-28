package kr.co.magic;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnectionTest2 {

	public static void main(String[] args) throws SQLException {
		// 데이터베이스 접속 정보 변수 선언
		String DB_URL = "jdbc:postgresql://localhost:5432/ezendb";
		// DB의 사용자정보
		String DB_USER = "postgres";
		String DB_PASSWORD = "0818";
		String DB_DRIVER = "org.postgresql.Driver";

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DB_DRIVER);
		ds.setUrl(DB_URL);
		ds.setUsername(DB_USER);
		ds.setPassword(DB_PASSWORD);
		
		//데이터베이스의 연결 얻음
		Connection conn = ds.getConnection();
		System.out.println("conn = " + conn);
	}

}
