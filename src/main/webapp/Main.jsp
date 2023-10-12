<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <%@ include file="Header.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/Main.css" />
    <script src="https://unpkg.com/embla-carousel/embla-carousel.umd.js"></script>
    <script src="https://unpkg.com/embla-carousel-autoplay/embla-carousel-autoplay.umd.js"></script>
  </head>
  <body>
	<div class="embla">
      <div class="embla__container">
        <img src="img/image1.png" class="embla__slide" />
        <img src="img/image2.png" class="embla__slide" />
        <img src="img/image3.png" class="embla__slide" />
      </div>
    </div>
    <script src="js/main.js"></script>
    <div class="container1">
      <a class="menu1">다른은행<br />금융관리</a>
      <a class="menu2" href="anotherac.do">등록</a>
      <a class="menu3">ㅣ</a>
      <a class="menu4">조회</a>
      <a class="menu5">ㅣ</a>
      <a class="menu6">이체</a>
      <a class="menu7">은행 종류</a>
    </div>
    <%@ include file="Footer.jsp" %>
  </body>
</html>
