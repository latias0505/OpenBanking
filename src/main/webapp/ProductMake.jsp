<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <%@ include file="Header.jsp" %>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/ProductMake.css" />
  </head>
  <body>
    <form action="productsave.do" method="post" class="signupform">
      <div class="maincontainer">
        <div class="productcontainer">
          <div class="productnamebox">
            <a class="label">상품 이름</a>
            <input
              type="text"
              placeholder="  상품 이름을 입력해주세요"
              class="productname"
              name="productname"
            />
          </div>
          <div class="productcontentbox">
            <a class="label">상품 내용</a>
            <textarea
              class="productcontent"
              name="productcontent"
              placeholder="  상품 내용을 작성해주세요"
              rows="20"
              cols="40"
            ></textarea>
          </div>
          <input type="submit" class="productbutton" value="등록하기" />
          <input
            type="button"
            class="backbutton"
            value="뒤로가기"
            onclick="location.href='productlistgo.do'"
          />
        </div>
      </div>
    </form>
    <%@ include file="Footer.jsp" %>
  </body>
</html>
