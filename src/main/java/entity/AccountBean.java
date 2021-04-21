package entity;

import java.io.Serializable;

public class AccountBean implements Serializable {
    private Integer userID;
    private String username;
    private String password;
    private String email;

    public int getUser_id() {
        return userID;
    }

    public AccountBean() {
    }

    public AccountBean(Integer userID, String username, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public AccountBean(String username, String password, String email) {
        this(null, username, password, email);
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
}
