package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 세션에서 userName 값을 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("userName");
		session.removeAttribute("userAdmin");
		
		return "Main.jsp";
	}
}
