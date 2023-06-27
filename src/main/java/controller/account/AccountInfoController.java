package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.account.AccountDAO;
import biz.account.AccountVO;

public class AccountInfoController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String accountId = request.getParameter("accountId");
		AccountDAO accountDAO = new AccountDAO();
		AccountVO account = accountDAO.getAccountByAccountId(accountId);
		
		request.setAttribute("account", account); // 조회한 계좌 정보를 request에 저장
		
		return "AccountInfo.jsp";
	}

}
