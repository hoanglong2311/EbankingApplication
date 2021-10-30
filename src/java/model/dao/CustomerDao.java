
package model.dao;

import java.util.ArrayList;
import model.bussiness.Customer;


public interface CustomerDao {
   //public ArrayList<Customer> getAllCustomers();
   public Customer getCustomer(int accNo);
   public int newCustomer(Customer customer);
   public void updateCustomer(int custNo, Customer customer);
   //public void updateCustomer(Customer customer);
}
