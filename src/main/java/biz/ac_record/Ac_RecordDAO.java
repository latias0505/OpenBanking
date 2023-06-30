package biz.ac_record;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ac_RecordDAO {
    private Connection conn;      // 데이터베이스 연결을 위한 Connection 객체
    private PreparedStatement stmt;   // SQL 문을 실행하기 위한 PreparedStatement 객체
    private ResultSet rs;      // SQL 쿼리의 결과를 저장하기 위한 ResultSet 객체
    
    public List<Ac_RecordVO> getAcRecordsByAccountId(long accountId) {
        List<Ac_RecordVO> acRecords = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM AC_RECORD WHERE ACCNUM = ? or RC_NUMBER= ? ";
 // accountId와 일치하는 ACCNUM 값을 가진 AC_RECORD 정보를 조회하는 SQL 문

            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, accountId); // 첫 번째 위치 홀더에 accountId 값을 설정
            stmt.setLong(2, accountId);

            rs = stmt.executeQuery(); // SQL 문 실행

            while (rs.next()) {
                Ac_RecordVO acRecord = new Ac_RecordVO();
                acRecord.setRcNo(rs.getInt("RC_NO"));
                acRecord.setAccNum(rs.getLong("ACCNUM"));
                acRecord.setId(rs.getString("ID"));
                acRecord.setRcType(rs.getString("RC_TYPE"));
                acRecord.setRcNumber(rs.getLong("RC_NUMBER"));
                acRecord.setRcMoney(rs.getLong("RC_MONEY"));
                acRecord.setRcName(rs.getString("RC_NAME"));
                acRecord.setRcText(rs.getString("RC_TEXT"));
                acRecord.setRcTime(rs.getDate("RC_TIME"));

                acRecords.add(acRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return acRecords;
    }

    // Ac_RecordVO 객체를 받아서 AC_RECORD 테이블에 저장하는 메서드
    public void saveAcRecord(Ac_RecordVO acRecord) {
        try {
            conn = JDBCUtil.getConnection();   // 데이터베이스 연결을 가져옴
            String sql = "INSERT INTO AC_RECORD (RC_NO, ACCNUM, ID, RC_TYPE, RC_NUMBER, RC_MONEY, RC_NAME, RC_TEXT, RC_TIME) " +
                         "VALUES ((SELECT NVL(MAX(RC_NO),0)+1 FROM AC_RECORD), ?, ?, ?, ?, ?, ?, ?, sysdate) ";   // INSERT 문을 정의
            
            int loc = 1;
            stmt = conn.prepareStatement(sql);   // PreparedStatement 객체 생성
            stmt.setLong(loc++, acRecord.getAccNum());   // 2번 위치 홀더에 AccNum 값을 설정
            stmt.setString(loc++, acRecord.getId());     // 3번 위치 홀더에 ID 값을 설정
            stmt.setString(loc++, acRecord.getRcType());     // 4번 위치 홀더에 RcType 값을 설정
            stmt.setLong(loc++, acRecord.getRcNumber());     // 5번 위치 홀더에 RcName 값을 설정
            stmt.setLong(loc++, acRecord.getRcMoney());     // 6번 위치 홀더에 RcMoney 값을 설정
            stmt.setString(loc++, acRecord.getRcName());
            stmt.setString(loc++, acRecord.getRcText());

            stmt.executeUpdate();   // SQL 문 실행
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);   // 사용한 객체들을 닫음
        }
    }
}
