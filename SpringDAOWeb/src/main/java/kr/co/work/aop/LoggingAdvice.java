package kr.co.work.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	
	@Around("execution(* kr.co.work.aop.MyMath.*(..))")		//pointcut - 부가기능이 적용될 메서드의 패턴
	public Object methodCallLog(ProceedingJoinPoint pjp) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("<< [start]");
		
		Object result = pjp.proceed(); 					//target의 메서드를 호출
		
		System.out.println((System.currentTimeMillis() - start) +"ms");
		System.out.println("result = " + result);
		System.out.println("<< [end]");
		System.out.println();
		return result;
	}
}