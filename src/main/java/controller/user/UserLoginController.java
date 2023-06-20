package controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class UserLoginController implements Controller {
    
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id"); // 입력된 아이디
        String password = request.getParameter("pass"); // 입력된 비밀번호
        
        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUserById(id);
        
        if (user != null && user.getPass().equals(password)) {
            // 아이디와 비밀번호가 일치할 경우 세션에 아이디를 저장합니다.
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getName());
            
            return "Main.jsp"; // Main.jsp로 이동합니다.
        } else {
            // 일치하지 않을 경우 JavaScript 경고창을 표시합니다.
            String errorMessage = "유효하지 않은 정보입니다.";
            String script = "<script>alert('" + errorMessage + "');</script>";
            request.setAttribute("script", script);
            
            // 경고창을 표시한 후 로그인 페이지로 이동
            return "UserLogin.jsp";
        }
    }
}
