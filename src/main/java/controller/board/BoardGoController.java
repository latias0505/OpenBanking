package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class BoardGoController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		if (userName == null) {
            // userName 값이 없으면 로그인 페이지로 리다이렉트
            return "UserLogin.jsp";
        }
		
		return "Board.jsp";
	}

}
