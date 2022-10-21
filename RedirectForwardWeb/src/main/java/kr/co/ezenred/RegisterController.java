package kr.co.ezenred;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		
		return "registerForm";
	}
	
	@RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
	public String save(User user, Model model) throws Exception {
		//유효성 검사
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			model.addAttribute("msg", msg);
			// return "redirect:/register/add?msg=" + msg;		//URL 재작성
			return "forward:/register/add";		//URL 재작성
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {

		return false;
	}
}
