<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="biz.anotherAC.AnotherAcDAO" %>
<%@ page import="biz.anotherAC.AnotherAcVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Information</title>
</head>
<body>
    <h1>Account Information</h1>
    
    <%-- DAO 객체 생성 --%>
    <% AnotherAcDAO dao = new AnotherAcDAO(); %>
    
    <%-- 원하는 계좌 번호 입력 --%>
    <% String acNum = "your_account_number"; %>
    
    <%-- DAO를 통해 계정 정보 가져오기 --%>
    <% List<AnotherAcVO> accountList = dao.getAccount(acNum); %>
    
    <%-- 가져온 계정 정보 출력 --%>
    <% if (accountList.isEmpty()) { %>
        <p>No account information found.</p>
    <% } else { %>
        <table>
            <tr>
                <th>Account Number</th>
                <th>ID</th>
                <th>Password</th>
                <th>Account Name</th>
                <th>Account Money</th>
            </tr>
            <% for (AnotherAcVO account : accountList) { %>
                <tr>
                    <td><%= account.getAccNum() %></td>
                    <td><%= account.getId() %></td>
                    <td><%= account.getAcPw() %></td>
                    <td><%= account.getAcName() %></td>
                    <td><%= account.getAcMoney() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>
    
</body>
</html>
