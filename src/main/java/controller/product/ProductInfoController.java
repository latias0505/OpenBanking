package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.product.ProductDAO;
import biz.product.ProductVO;

public class ProductInfoController implements Controller {
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 클릭한 상품의 PdNumber 파라미터 가져오기
        int pdNumber = Integer.parseInt(request.getParameter("pdNumber"));

        // ProductDAO를 사용하여 상품 정보 조회
        ProductDAO productDAO = new ProductDAO();
        ProductVO product = productDAO.getProductByPdNumber(pdNumber);

        // 조회한 상품 정보를 request 객체에 저장
        request.setAttribute("product", product);

        // ProductInfo.jsp로 이동
        return "ProductInfo.jsp";
    }
}
