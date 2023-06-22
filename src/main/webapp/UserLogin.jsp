<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <%@ include file="Header.jsp" %>
    <title>여기에 제목 입력</title>
    <link rel="stylesheet" type="text/css" href="css/UserLogin.css" />
    <script>
      <% String errorMessage = (String) request.getAttribute("errorMessage");
      if (errorMessage != null && !errorMessage.isEmpty()) { %>
        alert("<%= errorMessage %>");
      <% } %>
    </script>
  </head>
  <body>
    <div class="logincontainer">
      <div class="loginbox">
        <div class="loginbox2">
          <form action="userlogin.do" method="post">
            <div>
              <input type="text" class="idbox" placeholder="  아이디" name="id"/>
              <input type="password" class="pwbox" placeholder="  비밀번호" name="pass"/>
            </div>
            <input type="submit" value="로그인" class="loginbutton1" />
          </form>
          <div class="loginbox2-text">
            <a href="#">아이디 찾기</a>
            <span>ㅣ</span>
            <a href="#">비밀번호 찾기</a>
            <span>ㅣ</span>
            <a href="signupgo.do">회원가입</a>
            <br />
            <div class="kakakologin-container">
              <input type="button" value="카카오 로그인" class="kakaologin" />
              <img src="img/kakao.png" alt="카카오 로그인" class="kakaologo" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="Footer.jsp" %>
  </body>
</html>