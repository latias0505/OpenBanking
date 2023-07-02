package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class AnotherAcController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 등록 클릭 시 AnotherAc.jsp로 이동하는 로직 추가
		return "AnotherAc.jsp";
	}

}
