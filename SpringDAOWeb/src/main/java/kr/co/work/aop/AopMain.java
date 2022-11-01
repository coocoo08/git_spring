package kr.co.work.aop;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

public class AopMain {

	public static void main(String[] args) throws Exception {
		MyAdvice myAdvice = new MyAdvice();
		
		Class myClass = Class.forName("kr.co.work.aop.MyClass");
		Object obj = myClass.newInstance();
		
		for (Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}
}

// 핵심 기능 (메서드)에 공통 코드를 추가해야 함
class MyClass {
	@Transactional		//@Transactional이 설정된 핵심기능에만 부가기능 추가하기
	void ezen1() {
		System.out.println("ezen1() is called");
	}
	void ezen2() {
		
		System.out.println("ezen2() is called");
	}
	void itezen() {
		
		System.out.println("itezen() is called");
	}
}

// 보조기능
class MyAdvice {
	
	Pattern p = Pattern.compile("e.*");
	
	boolean matches(Method m) {
		Matcher matcher = p.matcher(m.getName());
		return matcher.matches();
	}
	
	void invoke(Method m, Object obj, Object...args) throws Exception {
		//if (matches(m)) {
		if (m.getAnnotation(Transactional.class) != null) {
			System.out.println("[이젠 brfore] { ");						
		}
		//}
		m.invoke(obj, args);					// ezen1, ezen2, itezen() 호출 가능
//		if (matches(m)) {
		if (m.getAnnotation(Transactional.class) != null) {
			System.out.println("} [이후 after] ");			
		}
//		}
	}
}