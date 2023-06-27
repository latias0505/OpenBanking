package biz.account;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public AccountVO getAccountByAccountId(String accountId) {
        AccountVO account = null;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ACCOUNT WHERE ACCNUM = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                account = new AccountVO();
                account.setAccNum(rs.getLong("ACCNUM"));
                account.setAcName(rs.getString("AC_NAME"));
                account.setPdNumber(rs.getInt("PD_NUMBER"));
                account.setAcMoney(rs.getInt("AC_MONEY"));
                account.setAcOpDate(rs.getDate("AC_OP_DATE"));
                account.setAcEdDate(rs.getDate("AC_ED_DATE"));
                account.setState(rs.getString("STATE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return account;
    }

    
    public void deleteAccount(long accNum) {
        try {
            conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM ACCOUNT WHERE ACCNUM = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, accNum);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
    
    public List<AccountVO> getAccountsByUserId(String userId) {
        List<AccountVO> accounts = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM ACCOUNT WHERE ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AccountVO account = new AccountVO();
                account.setAccNum(rs.getLong("ACCNUM"));
                account.setAcName(rs.getString("AC_NAME"));
                account.setPdNumber(rs.getInt("PD_NUMBER"));
                account.setAcMoney(rs.getInt("AC_MONEY"));
                account.setAcOpDate(rs.getDate("AC_OP_DATE"));
                account.setAcEdDate(rs.getDate("AC_ED_DATE"));
                account.setState(rs.getString("STATE"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return accounts;
    }


    public void insertAccount(AccountVO account) {
        try {
        	long accNum = generateAccNum();
            conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO ACCOUNT (ACCNUM, ID, AC_PW, AC_NAME, AC_MONEY, AC_OP_DATE, AC_ED_DATE, STATE, PD_NUMBER, BANK_CD) " +
                    "VALUES (?, ?, ?,?, ?, sysdate, sysdate+365, ?, ?, ?) ";

            int loc = 1;
            stmt = conn.prepareStatement(sql);
            stmt.setLong(loc++, Long.parseLong("159" + String.valueOf(accNum)));
            stmt.setString(loc++, account.getId());
            stmt.setLong(loc++, account.getAcPw());
            stmt.setString(loc++, account.getAcName());
            stmt.setInt(loc++, account.getAcMoney());
            stmt.setString(loc++, account.getState());
            stmt.setLong(loc++, account.getPdNumber());
            stmt.setString(loc++, account.getBankCd());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }


    private long generateAccNum() {
        long accNum = 0;
        while (true) {
            accNum = generateRandomNumber();
            if (isAccNumExists(accNum)) {
                break;
            }
        }
        return accNum;
    }

    private boolean isAccNumExists(long accNum) {
    	boolean bool = false;
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT COUNT(*) FROM ACCOUNT WHERE ACCNUM = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, accNum);
            rs = stmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                bool =  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return bool;
    }

    private long generateRandomNumber() {
        // 유니크한 계정 번호를 생성하는 로직을 구현합니다.
        // 원하는 방식에 맞게 계정 번호를 생성하고 반환합니다.
        // 예시로 7자리 랜덤 숫자를 생성하는 코드를 제공합니다.
        return (long) ((Math.random() * 9000000) + 1000000);
    }
}
