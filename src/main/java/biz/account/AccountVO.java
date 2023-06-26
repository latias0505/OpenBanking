package biz.account;

import java.util.Date;

public class AccountVO {
    private long accNum;
    private String id;
    private long acPw;
    private String acName;
    private Integer acMoney;
    private Date acOpDate;
    private Date acEdDate;
    private String state;
    private long pdNumber;
    private String bankCd;

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

    public long getAcPw() {
        return acPw;
    }

    public void setAcPw(long acPw) {
        this.acPw = acPw;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public Integer getAcMoney() {
        return acMoney;
    }

    public void setAcMoney(Integer acMoney) {
        this.acMoney = acMoney;
    }

    public Date getAcOpDate() {
        return acOpDate;
    }

    public void setAcOpDate(Date acOpDate) {
        this.acOpDate = acOpDate;
    }

    public Date getAcEdDate() {
        return acEdDate;
    }

    public void setAcEdDate(Date acEdDate) {
        this.acEdDate = acEdDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPdNumber() {
        return pdNumber;
    }

    public void setPdNumber(long pdNumber) {
        this.pdNumber = pdNumber;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }
    
    @Override
    public String toString() {
        return "AccountVO [accNum=" + accNum + ", id=" + id + ", acPw=" + acPw + ", acName=" + acName + ", acMoney="
                + acMoney + ", acOpDate=" + acOpDate + ", acEdDate=" + acEdDate + ", state=" + state + ", pdNumber="
                + pdNumber + ", bankCd=" + bankCd + "]";
    }
}
