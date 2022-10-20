package kr.co.ezen;

import java.util.Calendar;

// 년월일을 입력하면 해당 요일을 알려주는 프로그램
public class DayOfTheWeek {

	public static void main(String[] args) {
		//1. 입력
		String year = args[0];
		String month = args[1];
		String day = args[2];
		
		//2. 문자를 숫자로 바꿈
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);			// 날짜 setting
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		// 요일 리턴 (sunday = 1,...)
		
		/*
		 * " 일월화수목금토".charAt(1); => 일
		 * " 일월화수목금토".charAt(2); => 월
		 */
		char dayOfTheWeek = " 일월화수목금토".charAt(dayOfWeek);
		
		//3. 출력
		System.out.println(year + "년 " + month + "월 " + day + "일은 ");
		System.out.println(dayOfTheWeek + "요일입니다.");
	}
}
