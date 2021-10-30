
package model.dao;

import model.bussiness.Account;


public interface AccountDao {
    public int newAccount(Account account);
    public Account getAccount(int accNo);
    public void changePassword(int accNo, String newPassword);
    public void updateAccount(int accNo, double balance);
}
