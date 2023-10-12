<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/Header.css" />
    <script src="js/Header.js"></script>
  </head>
  <body>
    <div class="container">
      <img src="img/logo.png" alt="logo" class="logo" />
      <a class="logotitle" href="main.do">밤하늘 은행</a>

      <form action="logout.do">
        <input type="submit" value="로그아웃" class="loginbutton"
        onmouseout="hideLoginText()" <% if (session.getAttribute("userName") ==
        null) { %> style="display: none;" <% } %> />
      </form>
      <input type="button" value="   로그인" class="loginbutton" onclick="location.href='userlogingo.do'"
      <% if
      (session.getAttribute("userName") != null) { %> style="display: none;" <%
      } %> /> <img src="img/login.png" alt="loginlogo" class="loginlogo" <% if
      (session.getAttribute("userName") != null) { %> style="display: none;" <%
      } %> />
	   <ul class="menu" <% if (session.getAttribute("userName") != null) { %> style="margin-left: -18px;" <% } %>>
		<li>
		  <% if (session.getAttribute("userAdmin") != null && session.getAttribute("userAdmin").equals("admin")) { %>
		    <a class="bankItembutton" href="productlistgo.do">상품 관리</a>
		  <% } else { %>
		    <a onmouseover="showItemText()" onmouseout="hideItemText()" class="bankItembutton">개인</a>
		  <% } %>
		</li>
		<li>
			<% if (session.getAttribute("userAdmin") != null && session.getAttribute("userAdmin").equals("admin")) { %>
			<a>회원 관리</a>
			<% } else { %>
			<a href="mypage.do">마이페이지</a>
			 <% } %>
		</li>
		<li><a href="boardgo.do">은행 게시판</a></li>
		<li><a href="gamego.do">게임</a></li>
	   </ul>
    </div>
    <% String userName = (String) session.getAttribute("userName"); %> <% if
    (session.getAttribute("userName") != null) { %>
    <a
      style="
        float: left;
        margin-left: 100px;
        margin-top: -35px;
        font-size: 20px;
        font-weight: bold;
      "
    >
      <%= userName %>님 접속 중
    </a>
    <% } %>
    <div id="bankItem" style="visibility: hidden" >
      <a href="account.do">&nbsp;계좌</a>
      <a>ㅣ</a>
      <a href="productlistgo.do">상품</a>
    </div>
  </body>
</html>
