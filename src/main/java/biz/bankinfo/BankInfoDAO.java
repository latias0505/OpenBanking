package biz.bankinfo;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankInfoDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // 은행 정보 가져오기
    public List<BankInfoVO> getBankInfoList() {
        List<BankInfoVO> bankInfoList = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT BANK_CD, BANK_NAME FROM BANKINFO";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String bankCd = rs.getString("BANK_CD");
                String bankName = rs.getString("BANK_NAME");

                BankInfoVO bankInfo = new BankInfoVO();
                bankInfo.setBankCd(bankCd);
                bankInfo.setBankName(bankName);

                bankInfoList.add(bankInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return bankInfoList;
    }
}
