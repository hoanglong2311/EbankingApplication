<%@page import="model.bussiness.Customer"%>
<%@page import="model.dao.DAOFactory"%>
<%@page import="model.dao.CustomerDao"%>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header_admin.jsp" %>
<%@ include file="/includes/column_left_home_transfer.jsp" %>

<jsp:useBean class="model.bussiness.Translog" id="toAccount" scope="session"/>
<jsp:setProperty name="toAccount" property="*"/>
<!-- start the middle column -->

<section>
    <form action="transfer" method="POST">
        <h3>Do you want to keep continue transfer ?</h3>
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
            <td><input type="text" name="accNo" placeholder="Enter account number" id="accNo" pattern="[0-9]{4}" required="" value="${toAccount.accNo}" readonly=""></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" value="${Name}" readonly=""></td>
        </tr>
        <tr>
            <td>Transfer</td>
            <td><input type="text" name="amount" placeholder="Enter the amount" id="amount" pattern="^([1-9])[0-9]{1,10}$" required="" value="${toAccount.amount}" readonly=""></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Transfer"></td>
        </tr>
        </table>
    </form>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
