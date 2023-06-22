package biz.product;

public class ProductVO {
    private int pdNumber;
    private String pdName;
    private String pdContent;

    public int getPdNumber() {
        return pdNumber;
    }

    public void setPdNumber(int pdNumber) {
        this.pdNumber = pdNumber;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public String getPdContent() {
        return pdContent;
    }

    public void setPdContent(String pdContent) {
        this.pdContent = pdContent;
    }
    
    @Override
    public String toString() {
        return "UserVO [pdNumber=" + pdNumber + ", pdName=" + pdName + ", pdContent=" + pdContent + "]";
    }
}

