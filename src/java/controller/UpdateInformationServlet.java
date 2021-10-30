
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


@WebServlet(name = "UpdateInformationServlet", urlPatterns = {"/update-information"})
public class UpdateInformationServlet extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        Account a = (Account) (request.getSession()).getAttribute("ACC");
        CustomerDao customerDao = DAOFactory.getCustomerDao();
        Customer cust = customerDao.getCustomer(a.getCustNo());
            
        request.getSession().setAttribute("customer", cust);
        request.getRequestDispatcher("update_information.jsp").forward(request, response);
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
        
        Account a = (Account) (request.getSession()).getAttribute("ACC");
        int custNo = a.getCustNo();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int idNo = Integer.parseInt(request.getParameter("idNo"));
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(idNo, firstName, lastName, phoneNo, email, address, lastName, phoneNo);
        
        DAOFactory.getCustomerDao().updateCustomer(custNo, customer);
        DAOFactory.getTranslogDao().newActivies(new Translog(a.getAccNo(), "System", 0, 0));
        request.setAttribute("message", "<h3 style='color: blue'>Update successfully.</h3>");
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
