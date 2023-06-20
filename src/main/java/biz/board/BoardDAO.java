package biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import biz.common.JDBCUtil;
import biz.user.UserVO;

public class BoardDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static String BOARD_INSERT = "insert into board(seq, code, title, writer, shop, content) values"
            + "((select nvl(max(seq),0)+1 from board), ?, ?, ?, ?, ?)";
    private static String BOARD_LIST = "select * from board";

    private static String BOARD_GET = "select * from board where seq=?";

    private static String BOARD_UPDATE = "update board set title=?, shop=?, content=? where seq=?";

    private static String BOARD_DELETE = "delete from board where seq=?";

    private static String BOARD_SEARCH = "select * from board where writer=? or shop=? or code=? or title=?";
    
    public List<BoardVO> getBoardListByOwner(String owner) {
    	  List<BoardVO> boardList = new ArrayList<BoardVO>();
    	  try {
    	    conn = JDBCUtil.getConnection();
    	    stmt = conn.prepareStatement("SELECT * FROM board WHERE owner = ?");
    	    stmt.setString(1, owner);
    	    rs = stmt.executeQuery();
    	    while (rs.next()) {
    	      BoardVO board = new BoardVO();
    	      board.setCode(rs.getString("CODE"));
    	      board.setTitle(rs.getString("TITLE"));
    	      board.setWriter(rs.getString("WRITER"));
    	      board.setShop(rs.getString("SHOP"));
    	      boardList.add(board);
    	    }
    	  } catch (Exception e) {
    	    e.printStackTrace();
    	  } finally {
    	    JDBCUtil.close(rs, stmt, conn);
    	  }
    	  return boardList;
    	}
    
    public void updateBoardOwner(String owner, String code) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement("UPDATE board SET owner = ? WHERE code = ?");
            stmt.setString(1, owner);
            stmt.setString(2, code);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    
    public void updateBoardOwner(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement("UPDATE board SET owner = ? WHERE code = ?");
            stmt.setString(1, vo.getOwner());
            stmt.setString(2, vo.getCode());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void insertBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getCode());
            stmt.setString(2, vo.getTitle());
            stmt.setString(3, vo.getWriter());
            stmt.setString(4, vo.getShop());
            stmt.setString(5, vo.getContent());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setCode(rs.getString("CODE"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setShop(rs.getString("SHOP"));
                board.setContent(rs.getString("CONTENT"));
                board.setOwner(rs.getString("OWNER"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardList;
    }

    public BoardVO getBoard(BoardVO vo) {
        BoardVO board = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1, vo.getSeq());
            rs = stmt.executeQuery();

            if (rs.next()) {
                board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setCode(rs.getString("CODE"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setShop(rs.getString("SHOP"));
                board.setContent(rs.getString("CONTENT"));
                board.setOwner(rs.getString("OWNER"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return board;
    }

    public void updateBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getShop());
            stmt.setString(3, vo.getContent());
            stmt.setInt(4, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public void deleteBoard(BoardVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public List<BoardVO> SearchBoardList(BoardVO vo) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();
        try {
            conn = JDBCUtil.getConnection();
            String searchType = vo.getSearchType();
            String keyword = vo.getKeyword();
            String query = "SELECT * FROM board WHERE ";
            if (searchType.equals("writer")) {
                query += "writer = ?";
            } else if (searchType.equals("shop")) {
                query += "shop = ?";
            } else if (searchType.equals("code")) {
                query += "code = ?";
            } else if (searchType.equals("title")) {
                query += "title = ?";
            }
            stmt = conn.prepareStatement(query);
            stmt.setString(1, keyword);
            rs = stmt.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setSeq(rs.getInt("SEQ"));
                board.setCode(rs.getString("CODE"));
                board.setTitle(rs.getString("TITLE"));
                board.setWriter(rs.getString("WRITER"));
                board.setShop(rs.getString("SHOP"));
                board.setContent(rs.getString("CONTENT"));
                boardList.add(board);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return boardList;
    }
}
