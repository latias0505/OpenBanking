package controller.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.ac_record.Ac_RecordDAO;
import biz.ac_record.Ac_RecordVO;
import biz.account.AccountDAO;
import biz.account.AccountVO;

public class AccountInfoController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    String accountId = request.getParameter("accountId");
	    AccountDAO accountDAO = new AccountDAO();
	    AccountVO account = accountDAO.getAccountByAccountId(accountId);
	    
	    // accountId와 일치하는 AC_RECORD 정보를 가져옴
	    Ac_RecordDAO acRecordDAO = new Ac_RecordDAO();
	    List<Ac_RecordVO> acRecords = acRecordDAO.getAcRecordsByAccountId(account.getAccNum());
	    
	    request.setAttribute("account", account);
	    request.setAttribute("acRecords", acRecords); // AC_RECORD 정보를 request에 저장
	    
	    return "AccountInfo.jsp";
	}

}
