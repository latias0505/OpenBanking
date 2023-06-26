package biz.product;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public void deleteProduct(int pdNumber) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM PRODUCT WHERE pd_number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pdNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
        }
    }
    
    public void updateProduct(ProductVO product) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "UPDATE PRODUCT SET pd_name = ?, pd_content = ? WHERE pd_number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getPdName());
            stmt.setString(2, product.getPdContent());
            stmt.setInt(3, product.getPdNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
        }
    }
        
    public ProductVO getProductByPdNumber(int pdNumber) {
        ProductVO product = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM PRODUCT WHERE pd_number = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pdNumber);
            rs = stmt.executeQuery();

            if (rs.next()) {
                product = new ProductVO();
                product.setPdNumber(rs.getInt("pd_number"));
                product.setPdName(rs.getString("pd_name"));
                product.setPdContent(rs.getString("pd_content"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
        }
        return product;
    }

    
    public List<ProductVO> getAllProducts() {
        List<ProductVO> productList = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();

            String sql = "SELECT * FROM PRODUCT ORDER BY pd_number ASC";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProductVO product = new ProductVO();
                product.setPdNumber(rs.getInt("pd_number"));
                product.setPdName(rs.getString("pd_name"));
                product.setPdContent(rs.getString("pd_content"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        return productList;
    }


    // 상품 등록 메소드
    public void saveProduct(ProductVO product) {
        try {
        	conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO PRODUCT (pd_number, pd_name, pd_content)" + "VALUES (?, ?, ?)";
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product.getPdNumber());
            stmt.setString(2, product.getPdName());
            stmt.setString(3, product.getPdContent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
        }
    }

    // PD_NUMBER의 다음 숫자를 가져오는 메소드
    public int getNextPdNumber() {
        int nextPdNumber = 0;
        try {
        	conn = JDBCUtil.getConnection();

            String sql = "SELECT MAX(PD_NUMBER) AS MAX_PD_NUMBER FROM PRODUCT";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int maxPdNumber = rs.getInt("MAX_PD_NUMBER");
                nextPdNumber = maxPdNumber + 1;
            } else {
                nextPdNumber = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
        }
        return nextPdNumber;
    }
}
