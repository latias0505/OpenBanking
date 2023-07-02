<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="biz.product.ProductVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <%@ include file="Header.jsp" %>
  <title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="css/AccountMake.css" />
  <script>
    function goToAccount() {
      window.location.href = "account.do";
    }
    
    function validatePassword() {
      var password1 = document.getElementById("password1").value;
      var password2 = document.getElementById("password2").value;
      var isValid = /^\d{4}$/.test(password1);
      
      if (!isValid) {
        alert("비밀번호는 4자리 숫자만 입력해야 합니다.");
        return false;
      }
      
      if (password1 !== password2) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
      }
      
      return true;
    }
  </script>
</head>
<body>
  <form action="accountsave.do" method="post" class="accountform" onsubmit="return validatePassword()">
    <table>
    <tr>
        <td>
          <label for="pdNumber"">계좌 종류</label>
          <select name="pdNumber" id="pdNumber">
            <% 
            List<ProductVO> productList = (List<ProductVO>) request.getAttribute("productList");
            for (ProductVO product : productList) {
            %>
            <option value="<%= product.getPdNumber() %>"><%= product.getPdName() %></option>
            <% } %>
          </select>
        </td>
      </tr>
      <tr>
        <td>
          <label for="account_name">계좌 이름</label>
          <input type="text" name="account_name" id="account_name" />
        </td>
      </tr>
      <tr>
        <td>
          <label for="password1">계좌 비밀번호</label>
          <input type="password" name="password1" id="password1" maxlength="4" />
        </td>
      </tr>
      <tr>
        <td>
          <label for="password2">계좌 비밀번호 확인</label>
          <input type="password" name="password2" id="password2" maxlength="4" />
        </td>
      </tr>
    </table>
    <input type="button" value="취소" class="button2" onclick="goToAccount()">
    <input type="submit" class="button1" value="계좌 개설">
  </form>
  <%@ include file="Footer.jsp" %>
</body>
</html>
