<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/27/17
  Time: 9:27 AM
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
                    <!-- form content box Start -->
                    <div class="form-content-box">
                        <div class="details">
                            <!-- logo Start -->
                            <a href="/home" class="logo">
                                <img src="/resources/img/logo.png">
                            </a>
                            <!-- logo End -->
                            <h2>Đổi mật khẩu</h2>
                            <!-- Social Buttons-->

                            <!-- Divider-->
                            <div class="divider">
                                <span class="or-text">OR</span>
                            </div>
                            <!-- Form -->
                            <form:form action="change" method="POST" data-toggle="validator">
                                <label for="password" class="control-label">Mật khẩu mới:</label>
                                <input type="password" name="password" class="form-control" id="password" placeholder="Nhập mật khẩu mới"/>
                                <br>
                                <label for="repassword" class="control-label">Nhập lại mật khẩu:</label>
                                <input type="password" name="repassword" class="form-control" id="repassword" placeholder="Nhập lại mật khẩu"/>
                                &nbsp;
                                <input type="submit" name="submit" class="submit" value="Đổi mật khẩu">

                            </form:form>
                        </div>

                    </div>
                    <!-- form content box End -->
                </div>
            </div>
        </div>
        <jsp:include page="scrip.jsp" />
    </body>
</html>
