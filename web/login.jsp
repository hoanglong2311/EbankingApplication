
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html" errorPage="error.jsp" import="model.bussiness.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles/mystyles.css">
    </head>
    <section>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="confirm.jsp">
                    <h1>Sign Up</h1>
                    <input type="text" name="firstName" id="fname" placeholder="First Name" required=""/>
                    <input type="text" name="lastName" id="lname" placeholder="Last Name" required=""/>
                    <input type="text" name="idNo" id="idno" placeholder="Identification Number" pattern="[0-9]{9}" required=""/>
                    <input type="text" name="phoneNo" id="phoneNumber" placeholder="Phone number" pattern="0[0-9]{3} [0-9]{6}" required=""/>
                    <input type="email" name="email" id="email" placeholder="Email" required=""/>
                    <input type="text" name="address" id="address" placeholder="Address" required=""/>
                    <input type="text" name="balance" id="balance" placeholder="Initial balance" required=""/>
                    <!--<input type="file" id="img" name="img" accept="image/*">-->
                    <input type="password" name="password" id="password" placeholder="Password" required=""/>
                    <hr>
                    <button type="submit">Confirm</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="login" method="POST">
                    <h1>Sign In</h1>
                    <input type="text" name="accNo" id="user" placeholder="Account No" required=""/>
                    <input type="password" name="password" id="pass" placeholder="Password"  required=""/>
                    <button type="submit">Sign In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>Please login with your personal info</p>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your personal details and start your journey with us</p>
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="JS/mycode.js"></script>
    </section>
</html>

