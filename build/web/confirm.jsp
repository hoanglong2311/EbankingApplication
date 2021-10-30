
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="model.bussiness.Customer" id="cust" scope="session"/>
<jsp:useBean class="model.bussiness.Account" id="acc" scope="session"/>
<jsp:setProperty name="cust" property="*"/>
<jsp:setProperty name="acc" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/mystyles.css">
    </head>
    <section>
        <div class="container" id="container">
            <div>
                <form action="registration" method="POST">
                    <table>
                    <h1>Sign Up</h1>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" id="fname" placeholder="First Name" required="" value="${cust.firstName}"/></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" id="lname" placeholder="Last Name" required="" value="${cust.lastName}"/></td>
                    </tr>
                    <tr>
                        <td>CMND</td>
                        <td><input type="text" name="idNo" id="idno" placeholder="Identification Number" pattern="[0-9]{9}" required="" value="${cust.idNo}"/></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="text" name="phoneNo" id="phoneNumber" placeholder="Phone number" pattern="0[0-9]{3} [0-9]{6}" required="" value="${cust.phoneNo}"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" id="email" placeholder="Email" required="" value="${cust.email}"/></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" name="address" id="address" placeholder="Address" required="" value="${cust.address}"/></td>
                    </tr>
                    <tr>
                        <td>Balance</td>
                        <td><input type="text" name="balance" id="balance" placeholder="Initial Balance" required="" value="${acc.balance}"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="password" id="password" placeholder="Password" required="" value="${acc.password}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Register</button></td>
                    </tr>
                    </table>
                </form>
            </div>
        </div>
        <script src="JS/mycode.js"></script>
    </section>
</html>

