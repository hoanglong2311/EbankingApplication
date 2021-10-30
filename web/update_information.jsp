<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header_admin.jsp" %>
<%@ include file="/includes/column_left_home_updateInformation.jsp" %>

<%
    if (session.getAttribute("ACC") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!-- start the middle column -->

<section>
    <form action="update-information" method="POST">
        <h3>Update your information</h3>
        <table>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" id="fname" placeholder="Enter first Name" required="" value="${customer.firstName}"/></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lastName" id="lname" placeholder="Enter last Name" required="" value="${customer.lastName}"/></td>
        </tr>
        <tr>
            <td>Identification Number</td>
            <td><input type="text" name="idNo" id="idno" placeholder="Enter identification Number" pattern="[0-9]{9}" required="" value="${customer.idNo}"/></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><input type="text" name="phoneNo" id="phoneNumber" placeholder="Enter phone number" pattern="0[0-9]{3} [0-9]{6}" required="" value="${customer.phoneNo}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" id="email" placeholder="Enter email" required="" value="${customer.email}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" id="address" placeholder="Enter address" required="" value="${customer.address}"/></td>
        </tr>
        <tr><td><input type="submit" value="Update"></td></tr>
        </table>
    </form>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
