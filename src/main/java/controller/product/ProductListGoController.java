package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.product.ProductDAO;
import biz.product.ProductVO;
import controller.Controller;

public class ProductListGoController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		
		if (userName == null) {
            // userName 값이 없으면 로그인 페이지로 리다이렉트
            return "UserLogin.jsp";
        }
		
	    ProductDAO productDAO = new ProductDAO();
	    List<ProductVO> productList = productDAO.getAllProducts();

	    request.setAttribute("productList", productList);

	    return "ProductList.jsp";
	}


}

