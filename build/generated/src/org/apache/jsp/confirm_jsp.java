package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class confirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      model.bussiness.Customer cust = null;
      synchronized (session) {
        cust = (model.bussiness.Customer) _jspx_page_context.getAttribute("cust", PageContext.SESSION_SCOPE);
        if (cust == null){
          cust = new model.bussiness.Customer();
          _jspx_page_context.setAttribute("cust", cust, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      model.bussiness.Account acc = null;
      synchronized (session) {
        acc = (model.bussiness.Account) _jspx_page_context.getAttribute("acc", PageContext.SESSION_SCOPE);
        if (acc == null){
          acc = new model.bussiness.Account();
          _jspx_page_context.setAttribute("acc", acc, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("cust"), request);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("acc"), request);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/mystyles.css\">\n");
      out.write("    </head>\n");
      out.write("    <section>\n");
      out.write("        <div class=\"container\" id=\"container\">\n");
      out.write("            <div>\n");
      out.write("                <form action=\"registration\" method=\"POST\">\n");
      out.write("                    <table>\n");
      out.write("                    <h1>Sign Up</h1>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>First Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"firstName\" id=\"fname\" placeholder=\"First Name\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name</td>\n");
      out.write("                        <td><input type=\"text\" name=\"lastName\" id=\"lname\" placeholder=\"Last Name\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>CMND</td>\n");
      out.write("                        <td><input type=\"text\" name=\"idNo\" id=\"idno\" placeholder=\"Identification Number\" pattern=\"[0-9]{9}\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.idNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Phone Number</td>\n");
      out.write("                        <td><input type=\"text\" name=\"phoneNo\" id=\"phoneNumber\" placeholder=\"Phone number\" pattern=\"0[0-9]{3} [0-9]{6}\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.phoneNo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Email</td>\n");
      out.write("                        <td><input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Address</td>\n");
      out.write("                        <td><input type=\"text\" name=\"address\" id=\"address\" placeholder=\"Address\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cust.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Balance</td>\n");
      out.write("                        <td><input type=\"text\" name=\"balance\" id=\"balance\" placeholder=\"Initial Balance\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.balance}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password</td>\n");
      out.write("                        <td><input type=\"text\" name=\"password\" id=\"password\" placeholder=\"Password\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${acc.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <button type=\"submit\">Register</button>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"JS/mycode.js\"></script>\n");
      out.write("    </section>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
