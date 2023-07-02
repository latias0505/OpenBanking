<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="biz.account.AccountDAO" %>
<%@ page import="biz.account.AccountVO" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <%@ include file="Header.jsp" %>
  <title>Account List</title>
 <link rel="stylesheet" type="text/css" href="css/AccountList.css" />
  <script>
    function deleteAccounts() {
      var checkboxes = document.getElementsByName("selectedAccounts");
      var selectedAccounts = [];

      for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
          selectedAccounts.push(checkboxes[i].value);
        }
      }

      if (selectedAccounts.length > 0) {
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "accountdelete.do");

        for (var i = 0; i < selectedAccounts.length; i++) {
          var input = document.createElement("input");
          input.setAttribute("type", "hidden");
          input.setAttribute("name", "selectedAccounts");
          input.setAttribute("value", selectedAccounts[i]);
          form.appendChild(input);
        }

        document.body.appendChild(form);
        form.submit();
      }
    }
    
    function showAlert(message) {
      alert(message);
    }
  </script>
</head>
<body>
<div class="accountbody">
<div class="maincontainer">
  <h1>Account List</h1>
  <br>
  <div class="container3">
    <form action="accountmake.do" method="get">
      <table>
        <thead>
          <tr>
            <th>계좌 선택</th>
            <th>계좌 이름</th>
            <th>상품 번호</th>
            <th>계좌 번호</th>
            <th>계좌 잔액</th>
            <th>계좌 생성일</th>
            <th>계좌 만기일</th>
            <th>계좌 상태</th>
          </tr>
        </thead>
        <tbody>
          <% 
          AccountDAO accountDAO = new AccountDAO();
          String userId = (String) session.getAttribute("userId");
          List<AccountVO> accounts = accountDAO.getAccountsByUserId(userId);
          
          if (!accounts.isEmpty()) {
            for (AccountVO account : accounts) {
            %>
            <tr>
              <td>
                <input type="checkbox" name="selectedAccounts" value="<%= account.getAccNum() %>" />
              </td>
              <td><a href="accountinfo.do?accountId=<%= account.getAccNum() %>" style="text-decoration: none; color: inherit;"><%= account.getAcName() %></a></td>
              <td><%= account.getPdNumber() %></td>
              <td><%= account.getAccNum() %></td>
              <td><%= account.getAcMoney() %></td>
              <td><%= account.getAcOpDate() %></td>
              <td><%= account.getAcEdDate() %></td>
              <td><%= account.getState() %></td>
            </tr>
            <%
            }
          } else {
            %>
            <tr>
              <td colspan="8">가입한 계좌가 존재하지 않습니다.</td>
            </tr>
            <%
          }
          %>
        </tbody>
      </table>
      <div class="button-container">
        <button type="submit" class="button">계좌 개설</button>
        <% if (!accounts.isEmpty()) { %>
        <button type="button" class="button" onclick="deleteAccounts()">계좌 삭제</button>
        <% } %>
      </div>
    </form>

    <% if (request.getAttribute("errorMessage") != null) { %>
      <p class="message">${errorMessage}</p>
    <% } %>
  </div>
  </div>
  </div>
  <%@ include file="Footer.jsp" %>
</body>
</html>
