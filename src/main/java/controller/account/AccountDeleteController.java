package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.account.AccountDAO;

public class AccountDeleteController implements Controller {
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String[] selectedAccounts = request.getParameterValues("selectedAccounts");
        
        if (selectedAccounts != null && selectedAccounts.length > 0) {
            AccountDAO accountDAO = new AccountDAO();
            for (String accNum : selectedAccounts) {
                accountDAO.deleteAccount(Long.parseLong(accNum));
            }
        }
        
        // 계좌 삭제 후 이동할 페이지를 반환합니다.
        return "redirect:/account.do";
    }
}
