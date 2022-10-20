package kr.co.ezenac.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {

	public static void makeCookie(HttpServletResponse response, String cName, String cValuem,int cTime) {
	//쿠키 생성
	Cookie cookie = new Cookie(cName, cValuem);
	//경로 설정
	cookie.setPath("/");
	// 유지 기간 설정
	cookie.setMaxAge(cTime);
	//응답 객체에 추가
	response.addCookie(cookie);
	}
}
