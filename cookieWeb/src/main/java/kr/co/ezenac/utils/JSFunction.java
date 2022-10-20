package kr.co.ezenac.utils;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class JSFunction {

	public static void alterLocation(String msg, String url, JspWriter out) throws IOException {

		System.out.println(msg);
		System.out.println(url);
		String script = "" 
						+ "<script>" 
						+ "		alert( '"+msg+"' );" 
						+ "		location.href='"+url+"';" 
						+ "</script>";
		out.print(script);
	}

	public static void alterBack(String msg, JspWriter out) throws IOException {

		String script = "" 
						+ "<script>" 
						+ "		alert('"+msg+"');"
						+ "		history.back();" 
						+ "</script>";
		out.print(script);
	}
}
