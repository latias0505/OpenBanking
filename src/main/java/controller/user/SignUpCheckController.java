package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import controller.Controller;

public class SignUpCheckController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String usercode1 = request.getParameter("usercode1");
        String usercode2 = request.getParameter("usercode2");

        UserDAO userDAO = new UserDAO();

        // Check if ID exists
        if (id != null) {
            boolean isIdExists = userDAO.checkIfIdExists(id);

            if (isIdExists) {
                request.setAttribute("message", "이미 존재하는 ID입니다.");
            } else {
                request.setAttribute("message", "사용 가능한 ID입니다.");
            }
        }

        // Check if usercode exists
        if (usercode1 != null && usercode2 != null) {
        	String usercode = usercode1 + "-" + usercode2;
        	boolean isUserCodeExists = userDAO.checkIfUserCodeExists(usercode);

            if (isUserCodeExists) {
                request.setAttribute("message", "이미 존재하는 주민번호입니다.");
            } else {
                request.setAttribute("message", "사용 가능한 주민번호입니다.");
            }
        }

        return "SignUp.jsp";
    }
}
