<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Header Start -->
<header class="main-header">
    <div class="container">
        <nav id="navigation" class="navbar navbar-default navbar-fixed-top " style="background-color: rgba(64, 130, 230, 0.32);">
            <div class="navbar-header" style="padding-left: 50px;">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/home" class="logo">
                    <img src="/resources/img/logo.png">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding-right: 50px;">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="/home" class="" role="button" aria-haspopup="true" aria-expanded="false">Home</a>

                    </li>
                    <li class="dropdown">
                        <a href="/rooms" class=""  role="button" aria-haspopup="true" aria-expanded="false">Rooms</a>

                    </li>
                    <li class="dropdown">
                        <a href="login.html" class="" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Service</a></li>
                            <li><a href="#">Shopping Cart</a></li>
                            <li><a href="/checkout">Checkout</a></li>
                            <li><a href="/forgotpassword">Forgot Password</a></li>
                        </ul>
                    </li>
                    <li><a href="#">About</a></li>
                    <c:choose>
                        <c:when test="${empty user}">
                            <li><a href="/login">Login</a></li>
                            <li><a href="/register">Sign up</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="dropdown">
                                <a href="/profile" class="" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                     ${user.name}
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="/update">UPDATE</a></li>
                                    <li><a href="/change">CHANGEPASSWORD</a></li>
                                    <li>
                                        <c:if test="${user.roleEntity.id == 1}">
                                            <a href="/admin">ADMIN</a><br>
                                        </c:if>
                                    </li>
                                    <li><a href="/logout">LOGOUT</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
            <!-- /.container -->
        </nav>
    </div>
</header>
<!-- Header End -->
