package com.javalec.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {   // req와 resp를 받아서 실행하는 서블릿을 만듬.
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response);
}
