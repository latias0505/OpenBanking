package biz.anotherAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biz.account.AccountVO;
import biz.common.JDBCUtil;

public class AnotherAcDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public List<AnotherAcVO> getAccount(String acNum) {
       StringBuilder sql = new StringBuilder();
       sql.append("SELECT * ");
       sql.append("FROM ACCOUNT @test_link ");
       sql.append("WHERE AC_NUMBER = ? ");
       
       List<AnotherAcVO> hList = new ArrayList<>();
       
       try (
          Connection conn = JDBCUtil.getConnection();
          PreparedStatement pstmt = conn.prepareStatement(sql.toString());
          ){
          pstmt.setString(1, acNum);
          
          ResultSet rs = pstmt.executeQuery();
          
          while (rs.next()) {
        	 AnotherAcVO vo = new AnotherAcVO();
             
             //vo.setTrNum(rs.getInt()); 거래번호(아이디)
             vo.setAccNum(rs.getLong(1));
             vo.setId(rs.getString(2));
             vo.setAcPw(rs.getLong(3));
             vo.setAcName(rs.getString(4));
             vo.setAcMoney(rs.getInt(5));
             
             System.out.println("Account Number: " + vo.getAccNum());
             System.out.println("ID: " + vo.getId());
             System.out.println("Password: " + vo.getAcPw());
             System.out.println("Account Name: " + vo.getAcName());
             System.out.println("Account Money: " + vo.getAcMoney());
             
             hList.add(vo);
          }
          
       } catch (Exception e) {
          e.printStackTrace();
       }
       
       return hList;
    }
}