package dao;

import entity.AccountBean;

public interface AccountDao {
    public void insertAccount(AccountBean acc);
    public AccountBean getAccount(String username, String password);
    public AccountBean getAccount(String username);
    AccountBean getAccount(Integer id);
    public boolean ifExists(String username);
}
