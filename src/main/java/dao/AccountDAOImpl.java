package dao;

import ConfigDB.ConnProvider;
import entity.AccountBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAOImpl implements AccountDao{

    static Connection conn;
    static PreparedStatement pst;
    private static final String INSERT_SQL = "INSERT INTO accounts(username, password , email) values(?, ?, ?) ";
    @Override
    public void insertAccount(AccountBean acc) {
        int status = 0;
        if (acc != null) {
            try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, acc.getUsername());
                ps.setString(2, acc.getPassword());
                ps.setString(3, acc.getEmail());
                ps.setString(4, acc.getPassword());
                ps.setInt(5, 2);
                int numRowsAffected = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        acc.setUser_id(rs.getInt(1));
                    }
                } catch (Exception s) {
                    s.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public AccountBean getAccount(String username, String password) {
        AccountBean account = new AccountBean();
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("SELECT * FROM accounts WHERE username = ? and password = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                account.setUser_id(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone_num(rs.getString(5));
                account.setPhone_num(rs.getString(5));
                account.setRolenum(rs.getInt(6));
            }
            System.out.println(account.getUsername());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return account;
    }

    @Override
    public AccountBean getAccount(String username) {
        AccountBean account = new AccountBean();
        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                account.setUser_id(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
            }
            System.out.println(account.getUsername());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return account;
    }

    @Override
    public boolean ifExists(String username) {
        AccountBean account = new AccountBean();

        try {
            conn = ConnProvider.getConn();
            pst = conn.prepareStatement("SELECT * FROM accounts WHERE username = ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            return rs.next();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
