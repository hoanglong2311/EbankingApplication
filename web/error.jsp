<%@page isErrorPage="true" contentType="text/html" pageEncoding="utf-8" %>
<%@ include file="/includes/header.jsp" %>


<!-- start the middle column -->

<section>
    <h1>${pageContext.exception.message}</h1>
    
</section>


<!-- end the middle column -->

<%@ include file="/includes/column_right_news.jsp" %>
<%@ include file="/includes/footer.jsp" %>
