package kr.co.work;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// 모든 요청에 필터 적용 (필터를 적용 할 요청의 패턴 지정)
@WebFilter(urlPatterns = "/*")
public class PerformanceFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 초기화 작업
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리 작업
		long startTime = System.currentTimeMillis();
		
		// 서블릿 또는 다음 필터 호출
		chain.doFilter(request, response);
		
		// 후처리 작업
		HttpServletRequest req = (HttpServletRequest)request;
		String method = req.getMethod();
		String referer = req.getHeader("Referer");
		
		System.out.println("[" + referer + "] --> " + method + "[" + req.getRequestURI() + "]" );
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	@Override
	public void destroy() {
		// 정리 작업
		
	}

}
