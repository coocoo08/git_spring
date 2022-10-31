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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	final int FAIL = 0;

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
	public String save(@Valid User user, BindingResult result, Model model) throws UnsupportedEncodingException {
		//1. 유효성 검사 => 관심사로 분리
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		//2. DB에 새회원 정보를 저장
		//User객체 검증한 결과 에러가 있으면, registerForm을 이용해서 에러를 보여줘야 함.
		if (!result.hasErrors()) {
			int rowCnt = userDao.insertUser(user);
			
			if (rowCnt != FAIL) {
				return "registerinfo";
			}
		}
		return "registerForm";		// /WEB-INF/views/registerInfo.jsp
	}

	private boolean isValid(User user) {
		// 현재 유효하지 못하게 false로 설정함
		return false;
	}
}
