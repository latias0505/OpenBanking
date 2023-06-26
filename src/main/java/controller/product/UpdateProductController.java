package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import biz.product.ProductDAO;
import biz.product.ProductVO;

public class UpdateProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    int pdNumber = Integer.parseInt(request.getParameter("pdNumber"));
	    String pdName = request.getParameter("pdName");
	    String pdContent = request.getParameter("pdContent");

	    ProductDAO productDAO = new ProductDAO();
	    ProductVO product = productDAO.getProductByPdNumber(pdNumber);

	    if (product != null) {
	        product.setPdName(pdName);
	        product.setPdContent(pdContent);
	        productDAO.updateProduct(product);
	    }

	    return "productlistgo.do";
	}


}
