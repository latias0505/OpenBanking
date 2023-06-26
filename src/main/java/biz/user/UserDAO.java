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
    
    public void updateUser(UserVO user) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE USER_INFO SET ID = ?, PASSWORD = ?, PHONE = ?, EMAIL = ?, ADDRESS = ?, POSTCODE = ? WHERE NAME = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getPostcode());
            stmt.setString(7, user.getName());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
    
    public UserVO getUserByName(String name) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM USER_INFO WHERE NAME = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);

            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPass(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setUsercode(rs.getString("USERCODE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhone(rs.getString("PHONE"));
                user.setPostcode(rs.getString("POSTCODE"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setUserdate(rs.getDate("USERDATE").toLocalDate());
                user.setAdmin(rs.getString("USER_TYPE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
    
    // 아이디로 사용자 정보 가져오기
    public UserVO getUserById(String id) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM USER_INFO WHERE ID = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);

            rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPass(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setUsercode(rs.getString("USERCODE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPhone(rs.getString("PHONE"));
                user.setPostcode(rs.getString("POSTCODE"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setUserdate(rs.getDate("USERDATE").toLocalDate());
                user.setAdmin(rs.getString("USER_TYPE"));
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
            String sql = "INSERT INTO USER_INFO(id, password, name, usercode, email, phone, postcode, address, userdate, user_type) " +
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
