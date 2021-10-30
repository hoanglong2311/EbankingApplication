<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header_admin.jsp" %>
<%@ include file="/includes/column_left_home_changepassword.jsp" %>
<%
    if (session.getAttribute("ACC") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!-- start the middle column -->

<section>
    
    <form action="change-password" method="POST">
        <h3>Enter your current E-Banking password along with a new one to change it.</h3>
        <table>
            <tr>
                <td>Current Password</td>
                <td><input type="password" name="password" placeholder="Enter current password" required=""/></td>
            </tr>
            <tr>
                <td>New Password</td>
                <td><input type="password" name="new_password" placeholder="Enter new password" required=""/></td>
            </tr>
            <tr>
                <td>Confirm New Password</td>
                <td><input type="password" name="confirm_new_password" placeholder="Re-enter new password" required=""/></td>
            </tr>
            <tr><td><input type="submit" value="Change password"></td></tr>
        </table>
    </form>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
