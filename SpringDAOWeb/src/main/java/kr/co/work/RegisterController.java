package kr.co.work;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller("/register")
public class RegisterController {
	
	@Autowired
	UserDao userDao;

	@GetMapping(value = "/add")
	public String register() {
		return "registerForm";		// /WEB-INF/views/registerForm.jsp
	}
	
	@InitBinder
	public void registerValidate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		//UserValidator를 WebDataBinder의 로컬 validator로 등록(수동)
		binder.setValidator(new UserValidator());
	}
	
	@PostMapping(value = "/add")
	public String save(@Valid User user, Model model) throws UnsupportedEncodingException {
		//1.유효성 검사 => 관심사로 분리
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.","utf-8");
			return "redirect:/register/add?msg=" + msg;
		}
		return "registerinfo";		// /WEB-INF/views/registerInfo.jsp
	}

	private boolean isValid(User user) {
		// 현재 유효하지 못하게 false로 설정함
		return false;
	}
}
