package biz.bankinfo;

public class BankInfoVO {
    private String bankCd;
    private String bankName;

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "BankInfoVO [bankCd=" + bankCd + ", bankName=" + bankName + "]";
    }
}
