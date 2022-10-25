package kr.co.hugeleap.sub;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController4 {

	@RequestMapping("/ex5")
	public void ezen(Model model) throws Exception {
		model.addAttribute("msg","message from ExceptionController2.ezen()");
		throw new Exception("예외가 발생했습니다.");
	}

	@RequestMapping("/ex6")
	public String ezen2(Model model) throws Exception {
		throw new Exception("예외가 발생했습니다.");
	}

	@RequestMapping("/ex7")
	public String ezen3(Model model) throws Exception {
		throw new NullPointerException("널포인터 예외가 발생했습니다.");
	}

	@RequestMapping("/ex8")
	public void ezen4(Model model) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지않는 예외가 발생했습니다.");
	}

	

}
