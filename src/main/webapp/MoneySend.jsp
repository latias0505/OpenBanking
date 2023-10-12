<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <%@ include file="Header.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/MoneySend.css" />
  </head>
  <body>
    <form action="moneysend.do" method="POST">
    
    <div class="accountcontainer">
    	<div class="maintitle">
    		<a>계좌 정보</a>
    	</div>
      <!-- 계좌 정보 테이블 -->
      <table>
        <tr>
          <th>계좌 이름</th>
          <th>계좌 번호</th>
          <th>계좌 잔액</th>
        </tr>
        <tr>
          <td><c:out value="${acName}" /></td>
          <td><c:out value="${accNumber}" /></td>
          <td><c:out value="${acMoney}" /></td>
        </tr>
      </table>
      </div>
      
      <h1>계좌 이체</h1>
      <!-- 이체 양식 -->
      <table>
        <tr>
          <td>계좌번호 입력</td>
          <td><input type="number" name="accnum" /></td>
        </tr>
        <tr>
          <td>이체 금액</td>
          <td><input type="number" name="money" /></td>
        </tr>
        <tr>
        	<td>계좌이체 메모</td>
        	<td><input type="text" name="text"></td>
        </tr>
      </table>
      
      <!-- 이체 버튼과 뒤로가기 버튼 -->
      <input type="hidden" name="accNumber" value="${accNumber}" />
      <div class="buttoncontainer">
      <input type="submit" value="이체하기" class="send">
      <input type="button" value="뒤로가기" class="back">
      </div>
    </form>    
    <%@ include file="Footer.jsp" %>
  </body>
</html>
