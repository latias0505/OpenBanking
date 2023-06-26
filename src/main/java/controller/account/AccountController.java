package controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import biz.account.AccountDAO;
import biz.account.AccountVO;

public class AccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String userId = (String) session.getAttribute("userId");

		if (userName == null) {
			// userName 값이 없으면 로그인 페이지로 리다이렉트
			return "UserLogin.jsp";
		}

		AccountDAO accountDAO = new AccountDAO();
		List<AccountVO> accounts = accountDAO.getAccountsByUserId(userId);
		request.setAttribute("accounts", accounts);

		return "AccountList.jsp";
	}
}
