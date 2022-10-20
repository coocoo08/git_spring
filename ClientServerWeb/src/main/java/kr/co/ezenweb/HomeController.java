package kr.co.ezenweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
//		System.out.println("request.getScheme() : " + request.getScheme());
//		System.out.println("request.getCharacterEncoding() : " + request.getCharacterEncoding());
//		System.out.println("request.getMethod() : " + request.getMethod());
//		System.out.println("request.getProtocol() : " + request.getProtocol());
//		System.out.println("request.getServerName() : " + request.getServerName());
//		System.out.println("request.getServerPort() : " + request.getServerPort());
//		System.out.println("request.getRequestURL() : " + request.getRequestURL());
//		System.out.println("request.getRequestURI() : " + request.getRequestURI());
//		System.out.println("request.getContextPath() : " + request.getContextPath());
//		System.out.println("request.getServletPath() : " + request.getServletPath());
//		System.out.println("자바 웹 애플리케이션");

		return "home";
	}

}
