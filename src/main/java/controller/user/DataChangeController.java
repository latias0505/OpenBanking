package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class DataChangeController implements Controller {
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String postcode = request.getParameter("postcode");
        
        // 데이터베이스에 정보 업데이트
        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUserByName(name);
        user.setId(id);
        user.setPass(password);
        user.setPhone(phone);
        user.setEmail(email1 + "@" + email2);
        user.setAddress(address1 + ":" + address2);
        user.setPostcode(postcode);
        
        userDAO.updateUser(user);
        
        return "Main.jsp";
    }
}
