
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bussiness.Account;
import model.bussiness.Translog;
import model.dao.AccountDao;
import model.dao.DAOFactory;
import model.dao.TranslogDao;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/change-password"})
public class ChangePasswordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("change_password.jsp").forward(request, response);
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
        processRequest(request, response);
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
        AccountDao accountDao = DAOFactory.getAccountDao();
        TranslogDao translogDao = DAOFactory.getTranslogDao();
        
        Account account = (Account) (request.getSession()).getAttribute("ACC");
        String cpw = request.getParameter("password");
        String npw = request.getParameter("new_password");
        String cnpw = request.getParameter("confirm_new_password");
        int accNo = account.getAccNo();
        
        Account.changePassword(accNo, cpw, npw, cnpw);
        accountDao.changePassword(accNo, npw);
        translogDao.newActivies(new Translog(accNo, "Change PW", 0, 0));
        request.setAttribute("message", "<h3 style='color:blue'>Update password successfully!</h3>");
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
