package kr.co.ezenac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")			//1. 원격 호출 가능한 프로그램으로 등록 + 2. URL과 메서드를 연결
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 호출");
		
		//웹브라우저에서 전송된 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		//응답할 데이터 종류가 html임 설정
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//출력 스트림 PrintWriter 객체
		PrintWriter out = response.getWriter();
		
		//브라우저로 출력할 데이터를 문자열로 연결해서 html태그로 만듦
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + user_id;
		data += "<br>";
		data += "패스워드 : " + user_pw;
		data += "</body>";
		data += "</html>";
		
		//html 태그 문자열을 브라우저로 출력함
		out.print(data);
	}

}
