
package model.bussiness;

import java.io.Serializable;
import java.sql.Date;
import model.dao.AccountDao;
import model.dao.DAOFactory;

public class Account implements Serializable{
    private int CustNo;
    private int AccNo;
    private double balance;
    private String password;
    private Date lastAccess;

    public Account() {
    }

    public Account(int CustNo, int AccNo, double balance, String password, Date lastAccess) {
        this.CustNo = CustNo;
        this.AccNo = AccNo;
        this.balance = balance;
        this.password = password;
        this.lastAccess = lastAccess;
    }

    public Account(int Custno, double balance, String password) {
        this.CustNo = Custno;
        this.balance = balance;
        this.password = password;
    }
    

    public int getCustNo() {
        return CustNo;
    }

    public void setCustNo(int CustNo) {
        this.CustNo = CustNo;
    }

    public int getAccNo() {
        return AccNo;
    }

    public void setAccNo(int AccNo) {
        this.AccNo = AccNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        return "Account{" + "CustNo=" + CustNo + ", AccNo=" + AccNo + ", balance=" + balance + ", password=" + password + ", lastAccess=" + lastAccess + '}';
    }

    public static Account login(int accNo, String pw) {
        AccountDao accountDao = DAOFactory.getAccountDao();
        Account a = accountDao.getAccount(accNo);
        if (pw.equals(a.password)) return a;
        else throw new RuntimeException("Invalid login or password. Please try again.");
    }
    
    public static void changePassword(int accNo, String cpw, String npw, String cnpw) {
        AccountDao accountDao = DAOFactory.getAccountDao();
        Account a = accountDao.getAccount(accNo);
        
        if (!a.password.equals(cpw)) {
            throw new RuntimeException("Your current password is wrong!");
        } else if (!npw.equals(cnpw)) {
            throw new RuntimeException("Passwords do not match!");
        } 
    }
    
    public static double calBal(int accNo, double amount, String op) {
        Account a = DAOFactory.getAccountDao().getAccount(accNo);
        double result = 0;
        switch (op) {
            case "add":
                    result = a.getBalance() + amount;
                break;
            case "sub":
                    result = a.getBalance() - amount;
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
}
