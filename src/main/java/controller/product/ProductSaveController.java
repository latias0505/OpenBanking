package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.product.ProductDAO;
import biz.product.ProductVO;

public class ProductSaveController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 상품 정보를 파라미터에서 가져온다
        String productName = request.getParameter("productname");
        String productContent = request.getParameter("productcontent");

        // ProductVO 객체를 생성하고 상품 정보를 설정한다
        ProductVO product = new ProductVO();
        product.setPdName(productName);
        product.setPdContent(productContent);

        // ProductDAO를 사용하여 상품 저장 및 PD_NUMBER 가져오기
        ProductDAO productDAO = new ProductDAO();
        int nextPdNumber = productDAO.getNextPdNumber();
        product.setPdNumber(nextPdNumber);
        productDAO.saveProduct(product);

        // 상품 목록 페이지로 이동한다 (ProductList.jsp)
        return "productlistgo.do";
    }
}
