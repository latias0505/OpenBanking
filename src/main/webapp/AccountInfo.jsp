<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="biz.account.AccountDAO" %>
<%@ page import="biz.account.AccountVO" %>
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
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>
