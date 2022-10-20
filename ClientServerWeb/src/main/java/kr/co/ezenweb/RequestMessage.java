package kr.co.ezenweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {
	
	@RequestMapping("/requestmessage")
	private void ezen(HttpServletRequest request) {
		// request Line
		String requestLine = request.getMethod();			//GET 또는 POST
		requestLine += " " + request.getRequestURI();		//	/ezenweb/requestmessage
		
		String queryString = request.getQueryString();		// year=2022&month=10&day=13
		requestLine += queryString == null ? "" : "?" + queryString;
		requestLine += " " +request.getProtocol();		// HTTP/1.1
		System.out.println(requestLine);
		
		// request header
		Enumeration<String> e = request.getHeaderNames();
		
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			System.out.println(name + " : " + request.getHeader(name));
		}
		
		// request body	-- POST일 때만 해당, GET은 body가 없음
		final int CONTENT_LENTH = request.getContentLength();
		System.out.println("content lenth : " + CONTENT_LENTH);
		
		if (CONTENT_LENTH > 0) {
			byte[] content = new byte[CONTENT_LENTH];
			
			InputStream in;
			try {
				in = request.getInputStream();
				in.read(content, 0, CONTENT_LENTH);
				
				System.out.println();			// empty line
				System.out.println(new String(content, "utf-8")); 		// year=2022&month=10&day=13
			} catch (IOException e1) { e1.printStackTrace(); }
		}
	}
}
