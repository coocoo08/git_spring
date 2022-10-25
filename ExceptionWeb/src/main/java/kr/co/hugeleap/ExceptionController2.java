package kr.co.hugeleap;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {

	@RequestMapping("/ex__")
	public void ezen(Model model) throws Exception {
		model.addAttribute("msg","message from ExceptionController2.ezen()");
		throw new Exception("예외가 발생했습니다.");
	}

	@RequestMapping("/ex2__")
	public String ezen2(Model model) throws Exception {
		throw new Exception("예외가 발생했습니다.");
	}

	@RequestMapping("/ex3__")
	public String ezen3(Model model) throws Exception {
		throw new NullPointerException("널포인터 예외가 발생했습니다.");
	}

	@RequestMapping("/ex4__")
	public void ezen4(Model model) throws FileNotFoundException {
		throw new FileNotFoundException("파일이 존재하지않는 예외가 발생했습니다.");
	}

	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model model) {
		System.out.println("catcher() in ExceptionController2");
		System.out.println("model = " + model.getAttribute("msg"));	//다른 모델을 사용하고 있음.
		model.addAttribute("ex", ex); //예외정보가 모델에 담겨서 뷰에 전달 된 것임.
		return "error";
	}

	@ExceptionHandler({ NullPointerException.class, FileNotFoundException.class })
	public String catcher2(Exception ex, Model model) {
		model.addAttribute("ex", ex);
		return "error";
	}

}
