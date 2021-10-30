<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header_admin.jsp" %>
<%@ include file="/includes/column_left_home_transfer.jsp" %>

<%
    if (session.getAttribute("ACC") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!-- start the middle column -->

<section>
    <form action="confirm" method="POST">
        <h3>Interbank money transfer</h3>
        <table>
            <tr><td colspan="2"><p><b>From account</b></p></td></tr>
        <tr>
            <td>Name</td>
            <td><input value="${customer.firstName } ${customer.lastName}" readonly=""/></td>
        </tr>
        <tr>
            <td>Balance</td>
            <td><input value="${ACC.balance}" readonly=""/></td>
        </tr>
        <tr><td colspan="2"><p><b>to account</b></p></td></tr>
        <tr>
            <td>Account number</td>
            <td><input type="text" name="accNo" placeholder="Enter account number" pattern="[0-9]{4}" required=""></td>
        </tr>
        <tr>
            <td>Transfer</td>
            <td><input type="text" name="amount" placeholder="Enter the amount" pattern="^([1-9])[0-9]{1,10}$" required=""></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Confirm"></td>
        </tr>
        </table>
    </form>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
