<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header_admin.jsp" %>
<%@ include file="/includes/column_left_home_translog.jsp" %>
<%
    if (session.getAttribute("ACC") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!-- start the middle column -->

<section>
    <h1>Welcome to FPT E-Banking Management System</h1>

    <table border="2">
        <tr>
            <td>Time</td>
            <td>Task</td>
            <td>Amount</td>
            <td>Post balance</td>
        </tr>
    <c:forEach items="${activities}" var="act">
        <tr><td><c:out value="${act.time}"/></td>
            <td><c:out value="${act.task}"/></td>
            <td><c:out value="${act.amount}"/></td>
            <td><c:out value="${act.postBalance}"/></td>
        </tr>
    </c:forEach>
    </table>
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
