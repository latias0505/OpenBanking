<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.List" %>
<%@ page import="biz.product.ProductVO" %>
<% List<ProductVO> productList = (List<ProductVO>) request.getAttribute("productList"); %>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8" />
        <%@ include file="Header.jsp" %>
        <title>Insert title here</title>
        <link rel="stylesheet" type="text/css" href="css/ProductList.css" />
      </head>
      <body>
        <div class="productcontainer">
          <h1>은행 상품</h1>
          <div class="table-container">
            <table class="productlist">
              <tr class="producttitle">
                <td>상품 번호</td>
                <td>상품 명</td>
              </tr>
              <% for (ProductVO product : productList) { %>
              <tr>
                <td><%= product.getPdNumber() %></td>
                <td>
                  <a href="productinfo.do?pdNumber=<%= product.getPdNumber() %>"
                    ><%= product.getPdName() %></a
                  >
                </td>
              </tr>
              <% } %>
            </table>
            <% if (session.getAttribute("userAdmin") != null && session.getAttribute("userAdmin").equals("admin")) { %>
            <input
              type="button"
              value="상품 등록하기"
              onclick="location.href='productmakego.do'"
            />
            <% } %>
          </div>
        </div>
        <%@ include file="Footer.jsp" %>
      </body>
    </html>
  </ProductVO></ProductVO
>
