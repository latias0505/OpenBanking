<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="biz.product.ProductVO" %> <% ProductVO
product = (ProductVO) request.getAttribute("product"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <%@ include file="Header.jsp" %>
    <title>Product Information</title>
    <link rel="stylesheet" type="text/css" href="css/ProductInfo.css" />
  </head>
  <body>
    <div class="product-container">
      <h1>은행 상품 정보</h1>
      <form id="productForm" method="post">
      <div class="product-info">
        <table>
          <tr>
            <td>상품 번호:</td>
            <% if (session.getAttribute("userAdmin") != null &&
            session.getAttribute("userAdmin").equals("admin")) { %>
            <td>
              <input
                type="text"
                value="<%= product.getPdNumber() %>"
                readonly
                name="pdNumber"
              />
            </td>
            <% } else { %>
            <td><%= product.getPdNumber() %></td>
            <% } %>
          </tr>
          <tr>
            <td>상품 명:</td>
            <% if (session.getAttribute("userAdmin") != null &&
            session.getAttribute("userAdmin").equals("admin")) { %>
            <td><input type="text" name="pdName" value="<%= product.getPdName() %>" /></td>
            <% } else { %>
            <td><%= product.getPdName() %></td>
            <% } %>
          </tr>
          <tr>
            <td>상품 내용:</td>
            <% if (session.getAttribute("userAdmin") != null &&
            session.getAttribute("userAdmin").equals("admin")) { %>
            <td><input type="text" name="pdContent" value="<%= product.getPdContent() %>" /></td>
            <% } else { %>
            <td><%= product.getPdContent() %></td>
            <% } %>
          </tr>
        </table>
      </div>
      <input type="button" value="뒤로가기" onclick="location.href='productlistgo.do'" />
      <% if (session.getAttribute("userAdmin") != null && session.getAttribute("userAdmin").equals("admin")) { %>
      <input type="submit" value="수정하기" formaction="updateproduct.do" />
      <input type="button" value="삭제하기" onclick="submitForm('productdelete.do')" />
      <% } %>
      </form>
    </div>
    <%@ include file="Footer.jsp" %>

    <script>
      function submitForm(action) {
        var form = document.getElementById('productForm');
        form.action = action;
        form.submit();
      }
    </script>
  </body>
</html>
