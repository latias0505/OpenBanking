package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.account.AccountDAO;
import biz.account.AccountVO;

public class AccountSaveController implements Controller {
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        AccountVO account = new AccountVO();
        
        // 폼 데이터 가져오기
        String accountName = request.getParameter("account_name");
        String password = request.getParameter("password1");
        String userId = (String) request.getSession().getAttribute("userId");
        long pdNumber = Long.parseLong(request.getParameter("pdNumber"));
        
        // 계정 객체에 값 설정하기
        account.setId(userId);
        account.setAcPw(Long.parseLong(password));
        account.setAcName(accountName);
        account.setAcMoney(0);
        account.setPdNumber(pdNumber);
        account.setBankCd("159"); // 은행 코드가 항상 "056"이라고 가정합니다.
        account.setState("WAKE"); // STATE 값을 설정합니다.
        
        // 계정을 데이터베이스에 저장하기
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.insertAccount(account);
        
        return "redirect:/account.do";
    }
}
