
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JDBC Connection Pool</title>
</head>
<body>
    <h2>Data in Connection Pooled Database</h2>
    <table border="1">
    <th>Customer</th>
    <%
        InitialContext initialContext = new InitialContext();
        Context context = (Context) initialContext.lookup("java:comp/env");
        //The JDBC Data source that we just created
        DataSource ds = (DataSource) context.lookup("jdbc/mydb");
        Connection connection = ds.getConnection();

        if (connection == null)
        {
            throw new SQLException("Error establishing connection!");
        }
        String query = "select * from Customer";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {  
    %>
            <tr>
                <td><center><%=rs.getInt("IDNo")%></center></td>
            </tr>   
    <%  }  %>
   </table>
</body>
</html>

