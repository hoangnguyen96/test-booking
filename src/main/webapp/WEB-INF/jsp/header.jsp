<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<c:choose>--%>
    <%--<c:when test="${empty user}">--%>
        <%--<li><a href="/login">Login</a></li>--%>
        <%--<li><a href="/register">Signup</a></li>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<li class="dropdown">--%>
            <%--<a href="/login" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.name}<span class="caret"></span></a>--%>
            <%--<ul class="dropdown-menu">--%>
                <%--<li><a href="/update">UPDATE</a></li>--%>
                <%--<li><a href="/logout">LOGOUT</a></li>--%>
                <%--<li><a href="/change">CHANGEPASSWORD</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>

<div class="inner-header-agile ">
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1><a  href="index.html"><span>H</span>otel <p class="s-log">Booking</p></a>

            </h1>
        </div>
        <!-- navbar-header -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav ">
                <li class="active"><a href="index.html">Home</a></li>
                <li><a href="about.html">Rooms</a></li>
                <li class="dropdown">
                    <a href="codes.html" class="dropdown-toggle hvr-bounce-to-bottom" data-hover="Pages" data-toggle="dropdown" aria-expanded="false">Pages <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="icons.html">CheckIn</a></li>

                        <li><a href="codes.html">CheckOut</a></li>
                    </ul>
                </li>
                <li><a href="gallery.html">LOGIN</a></li>
                <li><a href="gallery.html">SIGNUP</a></li>
            </ul>

        </div>
        <div class="clearfix"> </div>
    </nav>
</div>
