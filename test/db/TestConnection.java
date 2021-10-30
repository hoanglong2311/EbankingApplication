package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import model.dao.DAOFactory;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection con = null;
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            if (con != null) {
                System.out.println("Connection Successful");
            } else {
                System.out.println("Connection Fail");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
