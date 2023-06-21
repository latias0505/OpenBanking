package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class SignUpController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 회원가입 JSP 페이지에서 전달된 파라미터 값을 가져옵니다.
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String usercode1 = request.getParameter("usercode1");
        String usercode2 = request.getParameter("usercode2");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String phone = request.getParameter("phone"); // 휴대폰 번호 가져오기
        String postcode = request.getParameter("postcode");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");

        // 주민등록번호 앞자리와 뒷자리를 합쳐서 usercode에 저장합니다.
        String usercode = usercode1 + "-" + usercode2;

        // 이메일을 조합하여 email에 저장합니다.
        String email = email1 + "@" + email2;
        
        String address = address1 + ":" + address2;

        // UserVO 객체에 회원 정보를 저장합니다.
        UserVO user = new UserVO();
        user.setId(id);
        user.setPass(password);
        user.setName(name);
        user.setUsercode(usercode);
        user.setEmail(email);
        user.setPhone(phone); // 휴대폰 번호 설정
        user.setPostcode(postcode);
        user.setAddress(address);
        user.setUserdate(LocalDate.now()); // 오늘 날짜 저장
        user.setAdmin("user"); // admin 값 설정

        // UserDAO를 사용하여 회원 정보를 데이터베이스에 저장합니다.
        UserDAO userDAO = new UserDAO();
        userDAO.insertUser(user);

        return "Main.jsp"; // 회원가입 완료 후 이동할 페이지를 지정하세요.
    }

}
