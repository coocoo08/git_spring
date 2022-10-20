package kr.co.ezensignup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController2 {
	
	//@RequestMapping대신에 @GetMapping, @PostMapping 사용 가능
	//@RequestMapping(value = "/register/add2", method = {RequestMethod.GET, RequestMethod.POST} ) // 신규회원 가입 화
	//@RequestMapping(value = "/register/add2") // 신규회원 가입
	@GetMapping(value = "/register/add2")
	public String register() {
		return "registerForm";		// /WEB-INF/views/registerForm.jsp
	}
	
	//@RequestMapping(value = "/register/save2")
	@PostMapping(value = "/register/save2")
	public String save(User user, Model model) throws UnsupportedEncodingException {
		//1.유효성 검사
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.","utf-8");
			return "redirect:/register/add2?msg=" + msg;
		}
		return "registerinfo";		// /WEB-INF/views/registerInfo.jsp
	}

	private boolean isValid(User user) {
		// 현재 유효하지 못하게 false로 설정함
		return false;
	}
}
