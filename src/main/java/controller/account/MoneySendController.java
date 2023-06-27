package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.account.AccountDAO;
import biz.account.AccountVO;
import controller.Controller;

public class MoneySendController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	String accNumber = request.getParameter("accNumber");
        String accNumInput = request.getParameter("accnum");
        String money = request.getParameter("money");// 입력된 계좌 번호 가져오기
        AccountDAO accountDAO = new AccountDAO();
        AccountVO account = accountDAO.getAccountByAccountId(accNumInput); // 데이터베이스에서 계좌 상세 정보 가져오기

        if (account == null) {
            // 데이터베이스에 계좌 번호가 없음
            request.setAttribute("errorMessage", "존재하지 않는 계좌번호입니다."); // 오류 메시지 설정
            return "/account.do"; // MoneySend.jsp 페이지로 리다이렉션
        } else {
            // 데이터베이스에 계좌 번호가 존재함
            if (accNumInput.equals(accNumber)) {
                // 계좌 번호가 일치함
                return "account.do"; // Main.jsp 페이지로 이동  이체 내역 테이블에 입금으로 저장해야함
            } else {
                // 계좌 번호가 일치하지 않음
                return "account.do"; // ProductList.jsp 페이지로 이동   이체 내역 테이블에 출금으로 저장해야함
            }
        }
    }
}
