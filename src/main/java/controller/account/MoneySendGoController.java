package controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.bankinfo.BankInfoDAO;
import biz.bankinfo.BankInfoVO;

public class MoneySendGoController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String acName = request.getParameter("acName");
        String accNumber = request.getParameter("accNumber");
        String acMoney = request.getParameter("acMoney");

        request.setAttribute("acName", acName);
        request.setAttribute("accNumber", accNumber);
        request.setAttribute("acMoney", acMoney);

        // BankInfoDAO를 사용하여 은행 정보 가져오기
        BankInfoDAO bankInfoDAO = new BankInfoDAO();
        List<BankInfoVO> bankInfoList = bankInfoDAO.getBankInfoList();
        request.setAttribute("bankInfoList", bankInfoList);

        return "MoneySend.jsp";
    }
}
