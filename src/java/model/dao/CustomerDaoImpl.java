
package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bussiness.Customer;

public class CustomerDaoImpl implements CustomerDao {

    private ArrayList<Customer> customers;
    private Connection con;
    private CallableStatement cs;
    private PreparedStatement ps;
    private ResultSet rs;

    public CustomerDaoImpl() {
    }

    @Override
    public int newCustomer(Customer customer) {
        int custNo = -1;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            
            ps = con.prepareStatement("INSERT INTO Customer (custFname, custLname, IDNo, Tel, Address, Email) OUTPUT INSERTED.CustNo VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getIdNo());
            ps.setString(4, customer.getPhoneNo());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getEmail());
            rs = ps.executeQuery();
            rs.next();
            custNo = rs.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return custNo;
    }
    
    @Override
    public Customer getCustomer(int custNo) {
        Customer customer = null;
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            ps = con.prepareCall("SELECT * FROM Customer WHERE CustNo = ?");
            ps.setInt(1, custNo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                String firstName =  rs.getString(2);
                String lastName = rs.getString(3);
                int Idno = rs.getInt(4);
                String phoneNo = rs.getString(5);
                String address = rs.getString(6);
                String email = rs.getString(7);
                customer = new Customer(Idno, firstName, lastName, phoneNo, email, address, lastName, phoneNo);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }
        return customer;
    }
    
    @Override
    public void updateCustomer(int custNo, Customer customer) {
        try {
            Class.forName(DAOFactory.DRIVER_NAME);
            con = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USER_ID, DAOFactory.PASSWORD);
            
            ps = con.prepareCall("UPDATE Customer \n" +
                                    "SET custFname = ?,\n" +
                                    "	custLname = ?,\n" +
                                    "	IDNo = ?,\n" +
                                    "	Tel = ?,\n" +
                                    "	[Address] = ?,\n" +
                                    "	Email = ?\n" +
                                    "WHERE CustNo = ?");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setInt(3, customer.getIdNo());
            ps.setString(4, customer.getPhoneNo());
            ps.setString(5, customer.getAddress());
            ps.setString(6, customer.getEmail());
            ps.setInt(7, custNo);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DAOFactory.closeConnection(con, ps, rs);
        }        
    }
    
}
