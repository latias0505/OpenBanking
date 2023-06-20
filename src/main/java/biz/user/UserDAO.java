package biz.user;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    // 아이디로 사용자 정보 가져오기
    public UserVO getUserById(String id) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM USERS WHERE ID = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPass(rs.getString("PASS"));
                user.setName(rs.getString("NAME"));
                user.setUsercode(rs.getString("USERCODE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhone(rs.getString("PHONE"));
                user.setPostcode(rs.getString("POSTCODE"));
                user.setAddress(rs.getString("ADRESS"));
                user.setUserdate(rs.getDate("USERDATE").toLocalDate());
                user.setAdmin(rs.getString("ADMIN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }

    public void insertUser(UserVO user) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO USERS(id, pass, name, usercode, email, phone, postcode, adress, userdate, admin) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getUsercode());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getPostcode());
            stmt.setString(8, user.getAddress());
            stmt.setObject(9, user.getUserdate()); // 수정: java.sql.Date 변환 없이 setObject로 설정
            stmt.setString(10, user.getAdmin());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
}
