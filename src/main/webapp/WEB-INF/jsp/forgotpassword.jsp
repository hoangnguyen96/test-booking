<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/26/17
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="head.jsp" />
    <body class="form-page-body">

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <!-- Form Content Box Start -->
                    <div class="form-content-box">
                        <!-- Header -->
                        <div class="details">
                            <!-- logo Start -->
                            <a href="/home" class="logo">
                                <img src="/resources/img/logo.png">
                            </a>
                            <!-- logo End -->
                            <h2>Forgot Password</h2>
                            <p>Please enter your email address below and we'll email you a link to a page where you can easily create a new password!</p>
                            <!-- Form -->
                            <form method="post" class="login" action="/home">
                                <!-- Email-->
                                <div class="form-group Email">
                                    <input type="email" class="input-text" name="email" id="email" placeholder="Email Address">
                                </div>
                                <!-- Btn -->
                                <input type="submit" name="submit" class="submit" value="Send Me Email">
                            </form>
                        </div>
                        <!-- Footer -->
                        <div class="footer">
                                        <span>
                                            I want to <a href="/login">return to login</a>
                                        </span>
                        </div>
                    </div>
                    <!-- Form Content Box End -->
                </div>
            </div>
        </div>
        <!-- Form Page Body End-->
        <jsp:include page="scrip.jsp" />
    </body>
</html>


