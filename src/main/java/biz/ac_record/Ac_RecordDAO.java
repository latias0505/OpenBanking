package biz.ac_record;

import biz.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ac_RecordDAO {
    private Connection conn;      // 데이터베이스 연결을 위한 Connection 객체
    private PreparedStatement stmt;   // SQL 문을 실행하기 위한 PreparedStatement 객체
    private ResultSet rs;      // SQL 쿼리의 결과를 저장하기 위한 ResultSet 객체

    // Ac_RecordVO 객체를 받아서 AC_RECORD 테이블에 저장하는 메서드
    public void saveAcRecord(Ac_RecordVO acRecord) {
        try {
            conn = JDBCUtil.getConnection();   // 데이터베이스 연결을 가져옴
            String sql = "INSERT INTO AC_RECORD (RC_NO, ACCNUM, ID, RC_TYPE, RC_NAME, RC_MONEY, RC_TIME) " +
                         "VALUES ((SELECT NVL(MAX(RC_NO),0)+1 FROM AC_RECORD), ?, ?, ?, ?, ?, sysdate) ";   // INSERT 문을 정의
            
            int loc = 1;
            stmt = conn.prepareStatement(sql);   // PreparedStatement 객체 생성
            stmt.setLong(loc++, acRecord.getAccNum());   // 2번 위치 홀더에 AccNum 값을 설정
            stmt.setString(loc++, acRecord.getId());     // 3번 위치 홀더에 ID 값을 설정
            stmt.setString(loc++, acRecord.getRcType());     // 4번 위치 홀더에 RcType 값을 설정
            stmt.setString(loc++, acRecord.getRcName());     // 5번 위치 홀더에 RcName 값을 설정
            stmt.setLong(loc++, acRecord.getRcMoney());     // 6번 위치 홀더에 RcMoney 값을 설정

            stmt.executeUpdate();   // SQL 문 실행
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);   // 사용한 객체들을 닫음
        }
    }
}
