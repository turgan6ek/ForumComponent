package entity;

import java.io.Serializable;

public class AccountBean implements Serializable {
    private Integer userID;
    private String username;
    private String password;
    private String email;
    private String phone_num;
    private int rolenum;

    public int getUser_id() {
        return userID;
    }

    public AccountBean() {
    }

    public AccountBean(Integer userID, String username, String password, String email, String phone_num, int rolenum) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_num = phone_num;
        this.rolenum = 2;
    }

    public AccountBean(String username, String password, String email, String phone_num, int rolenum) {
        this(null, username, password, email, phone_num, rolenum);
    }

    public void setUser_id(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getRolenum() {
        return rolenum;
    }

    public void setRolenum(int rolenum) {
        this.rolenum = rolenum;
    }
}
