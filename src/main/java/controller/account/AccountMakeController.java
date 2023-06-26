package controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.LoopTagStatus;

import controller.Controller;
import biz.product.ProductDAO;
import biz.product.ProductVO;

import java.util.List;

public class AccountMakeController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // ProductDAO를 사용하여 모든 제품 정보를 가져옴
        ProductDAO productDAO = new ProductDAO();
        List<ProductVO> productList = productDAO.getAllProducts();

        // request 객체에 productList를 저장
        request.setAttribute("productList", productList);

        return "AccountMake.jsp";
    }

}
