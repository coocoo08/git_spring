package kr.co.ezenweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDice {
	
	@RequestMapping("/rollDice")
	public void ezen(HttpServletResponse response) {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		int random1 = (int)(Math.random()*6)+1;
		int random2 = (int)(Math.random()*6)+1;
		try {
			out = response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("</head>");
			out.print("<body>");
			out.print("<img src='resources/img/dice"+ random1 +".jpg'>");
			out.print("<img src='resources/img/dice"+ random2 +".jpg'>");
			out.print("</body>");
			out.print("</html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
