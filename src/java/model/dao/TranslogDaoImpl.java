
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bussiness.Translog;


public class TranslogDaoImpl implements TranslogDao{
    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    @Override
    public int newActivies(Translog translog) {
        int logId = -1;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareCall("INSERT INTO TransLog (AccNo, Task, Amount, PostBalance) OUTPUT inserted.LogID VALUES (?, ?, ?, ?)");
            ps.setInt(1, translog.getAccNo());
            ps.setString(2, translog.getTask());
            ps.setDouble(3, translog.getAmount());
            ps.setDouble(4, translog.getPostBalance());
            rs = ps.executeQuery();
            rs.next();
            logId = rs.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TranslogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return logId;
    }
    
    
    @Override
    public ArrayList<Translog> getTranslogs(int logId) {
        ArrayList<Translog> translogs = new ArrayList<>();
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareStatement("SELECT * FROM TransLog WHERE AccNo = ?");
            ps.setInt(1, logId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Translog translog = new Translog();
                translog.setAccNo(rs.getInt(1));
                translog.setLogId(rs.getInt(2));
                translog.setTime(rs.getDate(3));
                translog.setTask(rs.getString(4));
                translog.setAmount(rs.getDouble(5));
                translog.setPostBalance(rs.getDouble(6));
                translogs.add(translog);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TranslogDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return translogs;
    }
}
