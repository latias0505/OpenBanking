package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class MyPageController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUserByName(userName);
		
		// MyPage.jsp에서 사용할 사용자 정보를 request에 설정
		request.setAttribute("user", user);
		
		return "MyPage.jsp";
	}
}
