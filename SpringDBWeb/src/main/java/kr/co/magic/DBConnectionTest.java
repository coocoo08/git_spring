package kr.co.magic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) throws SQLException {
		//데이터베이스 접속 정보 변수 선언
		String DB_URL = "jdbc:postgresql://localhost:5432/ezendb";
		//DB의 사용자정보
		String DB_USER = "postgres";
		String DB_PASSWORD = "0818";
		
		// 1) 데이터베이스의 연결을 얻음(connection 객체 생성)
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		// 2) Statement 객체 생성
		Statement stmt = conn.createStatement();
		
		// 시스템의 현 날짜시간 출력하는 쿼리
		String query =  "select * from t_user\r\n"
				+ "where id = 'ezen'";
		stmt.execute(query);
		
		// 3) Statement 객체의 executeQuery() 실행해서 ResultSet 객체를 생성.
		// query 실행 결과를 rs에 담음
		ResultSet rs = stmt.executeQuery(query);
		
		// 실행결과 담긴 rs에서 한줄씩 읽어서 출력
		while (rs.next()) {
			for (int i = 1; i < 8; i++) {
				String curDate = rs.getString(i);	//읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장.
				System.out.print(curDate + " ");
			}
		}
	}

}
