package controller.account;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.account.AccountDAO;
import biz.account.AccountVO;
import biz.ac_record.Ac_RecordDAO;
import biz.ac_record.Ac_RecordVO;
import controller.Controller;

public class MoneySendController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String accNumber = request.getParameter("accNumber");
        String accNumInput = request.getParameter("accnum");
        String money = request.getParameter("money");
        AccountDAO accountDAO = new AccountDAO();
        AccountVO account = accountDAO.getAccountByAccountId(accNumInput);

        if (account == null) {
            request.setAttribute("errorMessage", "존재하지 않는 계좌번호입니다.");
            return "/account.do";
        } else {
            int updatedRows = 0; // updatedRows 변수를 선언하고 초기값을 0으로 지정

            if (accNumInput.equals(accNumber)) {
                Ac_RecordDAO acRecordDAO = new Ac_RecordDAO();
                Ac_RecordVO acRecord = new Ac_RecordVO();
                acRecord.setAccNum(Long.parseLong(accNumber));
                acRecord.setId(request.getSession().getAttribute("userId").toString());
                acRecord.setRcType("입금");
                acRecord.setRcName(accNumInput);
                acRecord.setRcMoney(Long.parseLong(money));

                acRecordDAO.saveAcRecord(acRecord); // Ac_RecordVO 객체를 AC_RECORD 테이블에 저장합니다.

                // ACCOUNT 테이블의 AC_MONEY 값을 업데이트합니다.
                updatedRows = accountDAO.updateAccountMoney(accNumInput, Long.parseLong(money));
                if (updatedRows > 0) {
                    return "/account.do";
                } else {
                    request.setAttribute("errorMessage", "AC_MONEY 값 업데이트에 실패했습니다.");
                    return "/account.do";
                }
            } else {
                Ac_RecordDAO acRecordDAO = new Ac_RecordDAO();
                Ac_RecordVO acRecord = new Ac_RecordVO();
                acRecord.setAccNum(Long.parseLong(accNumber));
                acRecord.setId(request.getSession().getAttribute("userId").toString());
                acRecord.setRcType("출금");
                acRecord.setRcName(accNumInput);
                acRecord.setRcMoney(Long.parseLong(money));

                acRecordDAO.saveAcRecord(acRecord); // Ac_RecordVO 객체를 AC_RECORD 테이블에 저장합니다.

                updatedRows = accountDAO.withdrawAccountMoney(accNumber, Long.parseLong(money));
                if (updatedRows > 0) {
                    // 입금할 계좌에서는 +money 만큼 입금
                    int depositRows = accountDAO.updateAccountMoney(accNumInput, Long.parseLong(money));
                    if (depositRows > 0) {
                        return "/account.do";
                    } else {
                        request.setAttribute("errorMessage", "입금 처리에 실패했습니다.");
                        return "/account.do";
                    }
                } else {
                    request.setAttribute("errorMessage", "출금 처리에 실패했습니다.");
                    return "/account.do";
                }
            }


        }
    }
}
