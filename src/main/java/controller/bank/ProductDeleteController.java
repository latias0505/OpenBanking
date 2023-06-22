package controller.bank;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.product.ProductDAO;
import controller.Controller;

public class ProductDeleteController implements Controller {
    private ProductDAO productDAO = new ProductDAO();
	
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int pdNumber = Integer.parseInt(request.getParameter("pdNumber"));
        productDAO.deleteProduct(pdNumber);
		
        return "productlistgo.do";
    }
}
