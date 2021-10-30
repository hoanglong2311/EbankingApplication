package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bussiness.Account;
import model.bussiness.Customer;
import model.bussiness.Translog;
import model.dao.AccountDao;
import model.dao.CustomerDao;
import model.dao.DAOFactory;
import model.dao.TranslogDao;

public class RegistrationServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

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
        
        Customer c = (Customer) (request.getSession()).getAttribute("cust");
        //lay cust tren session
        Account a = (Account) (request.getSession()).getAttribute("acc");
        //lay acc tren session
        int cNo = DAOFactory.getCustomerDao().newCustomer(c);
        a.setCustNo(cNo);
        
        int accNo = DAOFactory.getAccountDao().newAccount(a);
        DAOFactory.getTranslogDao().newActivies(new Translog(accNo, "Register", 0, 0));
        
        request.setAttribute("message", "Your accNo is: " + accNo + ",you can login with this accNo.");
        request.getRequestDispatcher("home.jsp").forward(request, response);
        
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
