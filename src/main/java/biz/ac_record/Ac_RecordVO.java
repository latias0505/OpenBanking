package biz.ac_record;

import java.sql.Timestamp;

public class Ac_RecordVO {
    private int rcNo;
    private long accNum;
    private String id;
    private String rcType;
    private String rcName;
    private double rcMoney;
    private Timestamp rcTime;

    public int getRcNo() {
        return rcNo;
    }

    public void setRcNo(int rcNo) {
        this.rcNo = rcNo;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRcType() {
        return rcType;
    }

    public void setRcType(String rcType) {
        this.rcType = rcType;
    }

    public String getRcName() {
        return rcName;
    }

    public void setRcName(String rcName) {
        this.rcName = rcName;
    }

    public double getRcMoney() {
        return rcMoney;
    }

    public void setRcMoney(double rcMoney) {
        this.rcMoney = rcMoney;
    }

    public Timestamp getRcTime() {
        return rcTime;
    }

    public void setRcTime(Timestamp rcTime) {
    	this.rcTime = new Timestamp(System.currentTimeMillis());
    }
    
    @Override
    public String toString() {
        return "Ac_RecordVO [rcNo=" + rcNo + ", accNum=" + accNum + ", id=" + id + ", rcType=" + rcType + ", rcName="
                + rcName + ", rcMoney=" + rcMoney + ", rcTime=" + rcTime + "]";
    }
    
}
