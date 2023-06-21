package controller;

import java.util.HashMap;
import java.util.Map;

import controller.bank.ProductListGoController;
import controller.board.BoardGoController;
import controller.user.AdminLoginGoController;
import controller.user.DataChangeController;
import controller.user.LogoutController;
import controller.user.MainController;
import controller.user.MyPageController;
import controller.user.SignUpController;
import controller.user.SignUpGoController;
import controller.user.UserLoginController;
import controller.user.UserLoginGoController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/main.do", new MainController());
		mappings.put("/userlogingo.do", new UserLoginGoController());
		mappings.put("/adminlogingo.do", new AdminLoginGoController());
		mappings.put("/signupgo.do", new SignUpGoController());
		mappings.put("/signup.do", new SignUpController());
		mappings.put("/userlogin.do", new UserLoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/mypage.do", new MyPageController());
		mappings.put("/datachange.do", new DataChangeController());
		mappings.put("/productlistgo.do", new ProductListGoController());
		mappings.put("/boardgo.do", new BoardGoController());
	}
	public Controller getController(String path) {
		return mappings.get(path); 
	}
}
