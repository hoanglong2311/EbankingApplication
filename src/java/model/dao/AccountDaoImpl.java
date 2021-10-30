
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bussiness.Account;


public class AccountDaoImpl implements AccountDao {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int newAccount(Account account) {
        int accNo = -1;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            
            ps = con.prepareStatement("INSERT INTO Account (CustNo, Balance, Password) OUTPUT INSERTED.AccNo VALUES (?, ?, ?)");
            ps.setInt(1, account.getCustNo());
            ps.setDouble(2, account.getBalance());
            ps.setString(3, account.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) accNo = rs.getInt(1);
            else throw new RuntimeException("Uh oh, Please check your information again!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return accNo;
    }
    
    @Override
    public Account getAccount(int accNo) {
        Account acc = null;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT CustNo, Balance, Password, LastAccess FROM Account WHERE AccNo = ?");
            ps.setInt(1, accNo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int custNo = rs.getInt(1);
                double bal = rs.getDouble(2);
                String pw= rs.getString(3);
                Date lac = rs.getDate(4);
                acc = new Account(custNo, accNo, bal, pw, lac);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return acc;
    }
    
    @Override
    public void changePassword(int accNo, String newPassword) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareCall("UPDATE Account SET Password = ? WHERE AccNo = ?");
            ps.setString(1, newPassword);
            ps.setInt(2, accNo);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
    }
    
    @Override
    public void updateAccount(int accNo, double balance) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareCall("UPDATE Account\n" +
                                "SET Balance = ?\n" +
                                "WHERE AccNo = ?");
            ps.setDouble(1, balance);
            ps.setInt(2, accNo);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccountDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }        
    }
    
}
