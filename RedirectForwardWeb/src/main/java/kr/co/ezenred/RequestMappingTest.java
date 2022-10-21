package kr.co.ezenred;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingTest {

	@RequestMapping({"/login/hello.do", "/login/hi.do"})
	private void test1() {
		System.out.println("urlpatter=/login/hello.do");
	}
	
	@RequestMapping("/login/*")
	public void test2() {
		System.out.println("urlpatter=/login/*");
	}
	
	@RequestMapping("/login/**/temp/*.do")
	public void test3() {
		System.out.println("urlpatter=/login/**/temp/*.do");
	}
	
	@RequestMapping("/login/??")
	public void test4() {
		System.out.println("urlpatter=/login/??");
	}
	
	@RequestMapping("urlpatter=*.do")
	public void test5() {
		System.out.println("*.do");
	}
	
	@RequestMapping("/*.???")
	public void test6() {
		System.out.println("urlpatter=/*.???");
	}
}
