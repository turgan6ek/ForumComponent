package dao;

import entity.AccountBean;

public interface AccountDao {
    public void insertAccount(AccountBean acc);
    public AccountBean getAccount(String username, String password);
    public AccountBean getAccount(String username);
    public boolean ifExists(String username);
}
