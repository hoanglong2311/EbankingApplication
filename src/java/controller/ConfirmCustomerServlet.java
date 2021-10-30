
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bussiness.Account;
import model.bussiness.Customer;
import model.dao.AccountDao;
import model.dao.CustomerDao;
import model.dao.DAOFactory;


@WebServlet(name = "ConfirmCustomerServlet", urlPatterns = {"/confirm"})
public class ConfirmCustomerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        Account a  = (Account) (request.getSession()).getAttribute("ACC");
        
        int accNo = Integer.parseInt(request.getParameter("accNo"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        if (DAOFactory.getAccountDao().getAccount(accNo) == null) {
            request.setAttribute("message", "<h3 style='color: red'>This accNo does not exist.</h3>");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else if (a.getBalance() < amount) {
            request.setAttribute("message", "<h3 style='color: red'>Not enough balance.</h3>");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            Account toAccount = DAOFactory.getAccountDao().getAccount(accNo);
            Customer tcust = DAOFactory.getCustomerDao().getCustomer(toAccount.getCustNo());
            request.setAttribute("Name", tcust.getFirstName() + " " + tcust.getLastName());
            request.getRequestDispatcher("confirm_transfer.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
