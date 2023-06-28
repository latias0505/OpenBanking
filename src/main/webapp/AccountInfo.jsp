<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="biz.account.AccountDAO" %>
<%@ page import="biz.account.AccountVO" %>
<%@ page import="biz.ac_record.Ac_RecordVO" %>
<%@ page import="java.util.Comparator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="Header.jsp" %>
<title>Account Information</title>
<link rel="stylesheet" type="text/css" href="css/AccountInfo.css" />
</head>
<body>
<div class="accountcontainer">
<h1><%= session.getAttribute("userName") %>님의 계좌 정보</h1>
<form action="moneysendgo.do" method="post">
	<table>
		<tr>
			<th>계좌 이름</th>
			<th>상품 번호</th>
			<th>계좌 번호</th>
			<th>계좌 잔액</th>
			<th>계좌 생성일</th>
			<th>계좌 만기일</th>
			<th>계좌 상태</th>
		</tr>
		<%
		String accountId = request.getParameter("accountId");
		AccountDAO accountDAO = new AccountDAO();
		AccountVO account = accountDAO.getAccountByAccountId(accountId);
		if (account != null) {
		%>
		<tr>
			<td><%= account.getAcName() %></td>
			<td><%= account.getPdNumber() %></td>
			<td><%= account.getAccNum() %></td>
			<td><%= account.getAcMoney() %></td>
			<td><%= account.getAcOpDate() %></td>
			<td><%= account.getAcEdDate() %></td>
			<td><%= account.getState() %></td>
			<input type="hidden" name="acName" value="<%= account.getAcName() %>">
	        <input type="hidden" name="accNumber" value="<%= account.getAccNum() %>">
	        <input type="hidden" name="acMoney" value="<%= account.getAcMoney() %>">
		</tr>
		<%
		}
		%>
	</table>
		<button type="submit">입금 및 이체</button>
	</form>
	<table>
        <tr>
            <th>거래 번호</th>
            <th>거래 종류</th>
            <th>금액</th>
            <th>거래 상대</th>
            <th>이체 날짜</th>
        </tr>
        <%-- AC_RECORD 정보 출력 --%>
        <% 
		List<Ac_RecordVO> acRecords = (List<Ac_RecordVO>) request.getAttribute("acRecords");
		if (acRecords != null) {
		    // Ac_RecordVO 리스트를 RcNo를 기준으로 내림차순 정렬합니다.
		    acRecords.sort(Comparator.comparingInt(Ac_RecordVO::getRcNo).reversed());
		    
		    for (Ac_RecordVO acRecord : acRecords) {
		%>
        <tr>
            <td><%= acRecord.getRcNo() %></td>
            <td><%= acRecord.getRcType() %></td>
            <td><%= acRecord.getRcMoney() %></td>
            <td><%= acRecord.getRcName() %></td>
            <td><%= acRecord.getRcTime() %></td>
        </tr>
        <% }
        } %>
    </table>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>
