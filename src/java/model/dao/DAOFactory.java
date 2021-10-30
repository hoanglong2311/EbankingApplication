
package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DAOFactory {
    
    
    public static final String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String DATABASE_NAME = "Ebanking";
    public static final String USER_ID = "sa";
    public static final String PASSWORD = "12345";
    public static final String URL = "jdbc:sqlserver://HLONG;databaseName=Ebanking";
    
    public static Connection crateConnection() {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) context.lookup("jdbc/mydb");
            return ds.getConnection();
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static CustomerDao getCustomerDao() {
        return new CustomerDaoImpl();
    }
    
    public static AccountDao getAccountDao() {
        return new AccountDaoImpl();
    }
    
    public static TranslogDao getTranslogDao() {
        return new TranslogDaoImpl();
    }
}
