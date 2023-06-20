package biz.user;

import java.time.LocalDate;
import java.util.Date;

public class UserVO {
    private String id;
    private String pass;
    private String name;
    private String usercode;
    private String email;
    private String phone;
    private String postcode;
    private String address;
    private LocalDate userdate;
    private String admin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getUserdate() {
        return userdate;
    }

    public void setUserdate(LocalDate userdate) {
        this.userdate = userdate;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "UserVO [id=" + id + ", pass=" + pass + ", name=" + name + ", usercode=" + usercode + ", email=" + email
                + ", phone=" + phone + ", postcode=" + postcode + ", address=" + address + ", userdate=" + userdate
                + ", admin=" + admin + "]";
    }
}