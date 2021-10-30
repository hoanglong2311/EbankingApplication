
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
import model.bussiness.Translog;
import model.dao.CustomerDao;
import model.dao.DAOFactory;
import model.dao.TranslogDao;

@WebServlet(name = "TransferServlet", urlPatterns = {"/transfer"})
public class TransferServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

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
        Account a = (Account) (request.getSession()).getAttribute("ACC");
        
        CustomerDao customerDao = DAOFactory.getCustomerDao();
        Customer cust = customerDao.getCustomer(a.getCustNo());
        
        request.getSession().setAttribute("customer", cust);
        request.getRequestDispatcher("transfer.jsp").forward(request, response);
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
        
        PrintWriter out = response.getWriter();
        Translog translog = (Translog) (request.getSession()).getAttribute("toAccount");
        
        Account a = (Account) (request.getSession().getAttribute("ACC"));
        Account ta = DAOFactory.getAccountDao().getAccount(translog.getAccNo());
        
        double bal_a = Account.calBal(a.getAccNo(), translog.getAmount(), "sub");
        double bal_ta = Account.calBal(ta.getAccNo(), translog.getAmount(), "add");
        
        DAOFactory.getAccountDao().updateAccount(a.getAccNo(), bal_a);
        DAOFactory.getAccountDao().updateAccount(ta.getAccNo(), bal_ta);
        
        request.setAttribute("message", "Tranfer successfull");
        //request.getSession().removeAttribute("toAccount");
        //request.getSession().removeAttribute("customer");
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
