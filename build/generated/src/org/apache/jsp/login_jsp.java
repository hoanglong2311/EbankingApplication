package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.bussiness.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"error.jsp", true, 8192, true);
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
      out.write("            <div class=\"form-container sign-up-container\">\n");
      out.write("                <form action=\"confirm.jsp\" method=\"POST\">\n");
      out.write("                    <h1>Sign Up</h1>\n");
      out.write("                    <input type=\"text\" name=\"firstName\" id=\"fname\" placeholder=\"First Name\" required=\"\"/>\n");
      out.write("                    <input type=\"text\" name=\"lastName\" id=\"lname\" placeholder=\"Last Name\" required=\"\"/>\n");
      out.write("                    <input type=\"text\" name=\"idNo\" id=\"idno\" placeholder=\"Identification Number\" pattern=\"[0-9]{9}\" required=\"\"/>\n");
      out.write("                    <input type=\"text\" name=\"phoneNo\" id=\"phoneNumber\" placeholder=\"Phone number\" pattern=\"0[0-9]{3} [0-9]{6}\" required=\"\"/>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email\" required=\"\"/>\n");
      out.write("                    <input type=\"text\" name=\"address\" id=\"address\" placeholder=\"Address\" required=\"\"/>\n");
      out.write("                    <input type=\"text\" name=\"balance\" id=\"balance\" placeholder=\"Initial balance\" required=\"\"/>\n");
      out.write("                    <!--<input type=\"file\" id=\"img\" name=\"img\" accept=\"image/*\">-->\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Password\" required=\"\"/>\n");
      out.write("                    <hr>\n");
      out.write("                    <button type=\"submit\">Confirm</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-container sign-in-container\">\n");
      out.write("                <form action=\"login\" method=\"POST\">\n");
      out.write("                    <h1>Sign In</h1>\n");
      out.write("                    <input type=\"text\" name=\"accNo\" id=\"user\" placeholder=\"Account No\" required=\"\"/>\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"pass\" placeholder=\"Password\"  required=\"\"/>\n");
      out.write("                    <button type=\"submit\">Sign In</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"overlay-container\">\n");
      out.write("                <div class=\"overlay\">\n");
      out.write("                    <div class=\"overlay-panel overlay-left\">\n");
      out.write("                        <h1>Welcome Back!</h1>\n");
      out.write("                        <p>Please login with your personal info</p>\n");
      out.write("                        <button class=\"ghost\" id=\"signIn\">Sign In</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"overlay-panel overlay-right\">\n");
      out.write("                        <h1>Hello, Friend!</h1>\n");
      out.write("                        <p>Enter your personal details and start your journey with us</p>\n");
      out.write("                        <button class=\"ghost\" id=\"signUp\">Sign Up</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
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
