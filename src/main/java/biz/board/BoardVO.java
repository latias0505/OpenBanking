package biz.board;

import java.util.Date;

public class BoardVO {
    private int seq;
    private String code;
    private String title;
    private String writer;
    private String shop;
    private String content;
    private String searchType;
    private String keyword;
    private String owner;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", code=" + code + ", title=" + title + ", writer=" + writer + ", shop=" + shop
                + ", content=" + content + ", searchType=" + searchType + ", keyword=" + keyword + ", owner=" + owner + "]";
    }


}
