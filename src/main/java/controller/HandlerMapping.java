package controller;

import java.util.HashMap;
import java.util.Map;

import controller.account.AccountController;
import controller.account.AccountDeleteController;
import controller.account.AccountInfoController;
import controller.account.AccountMakeController;
import controller.account.AccountSaveController;
import controller.account.AnotherAcController;
import controller.account.MoneySendController;
import controller.account.MoneySendGoController;
import controller.board.BoardGoController;
import controller.product.ProductDeleteController;
import controller.product.ProductInfoController;
import controller.product.ProductListGoController;
import controller.product.ProductMakeGoController;
import controller.product.ProductSaveController;
import controller.product.UpdateProductController;
import controller.user.DataChangeController;
import controller.user.LogoutController;
import controller.user.MainController;
import controller.user.MyPageController;
import controller.user.SignUpCheckController;
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
		mappings.put("/signupgo.do", new SignUpGoController());
		mappings.put("/signup.do", new SignUpController());
		mappings.put("/userlogin.do", new UserLoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/mypage.do", new MyPageController());
		mappings.put("/datachange.do", new DataChangeController());
		mappings.put("/productlistgo.do", new ProductListGoController());
		mappings.put("/boardgo.do", new BoardGoController());
		mappings.put("/productsave.do", new ProductSaveController());
		mappings.put("/productmakego.do", new ProductMakeGoController());
		mappings.put("/productinfo.do", new ProductInfoController());
		mappings.put("/updateproduct.do", new UpdateProductController());
		mappings.put("/productdelete.do", new ProductDeleteController());
		mappings.put("/account.do", new AccountController());
		mappings.put("/accountmake.do", new AccountMakeController());
		mappings.put("/accountsave.do", new AccountSaveController());
		mappings.put("/accountdelete.do", new AccountDeleteController());	
		mappings.put("/accountinfo.do", new AccountInfoController());
		mappings.put("/moneysendgo.do", new MoneySendGoController());
		mappings.put("/moneysend.do", new MoneySendController());
		mappings.put("/signupcheck.do", new SignUpCheckController());
		mappings.put("/anotherac.do", new AnotherAcController());
	}
	public Controller getController(String path) {
		return mappings.get(path); 
	}
}
