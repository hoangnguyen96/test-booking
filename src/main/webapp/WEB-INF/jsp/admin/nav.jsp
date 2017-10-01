<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#"></a>
    </div>

    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>

    <!-- Top Navigation: Left Menu -->
    <ul class="nav navbar-nav navbar-left navbar-top-links">
        <li><a href="/"><i class="fa fa-home fa-fw"></i> Trang Chủ</a></li>
    </ul>

    <!-- Top Navigation: Right Menu -->
    <ul class="nav navbar-right navbar-top-links">
        <li class="dropdown navbar-inverse">


            <a class="note dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw" ></i>
            </a>

            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="/admin" style="text-align: center;">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> Bạn có : <span style="color: #cc3829; font-size: 16px; font-weight: bold;">
                            </span> hóa đơn mới
                        </div>
                    </a>
                </li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <b class="caret"></b>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="/logout"><i class="fa fa-sign-out fa-fw"></i>Đăng xuất</a>
                </li>
            </ul>
        </li>
    </ul>

    <!-- Sidebar -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">

            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div>
                        <a style="font-size: 22px; margin-left: 25px;text-decoration: none;"><i class="fa fa-building"></i>BOOKING</a>
                    </div>

                </li>
                <li>
                    <a href="/admin" class="active"><i class="fa fa-bar-chart"></i> Thống kê</a>
                </li>
                <li>
                    <a href="/user"><i class="fa fa-address-card-o"></i> User</a>
                </li>
                <li>
                    <a href="/order"><i class="fa fa-first-order"></i> Order</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-hotel"></i> Hotel<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                             <a href="/room">Rooms</a>
                        </li>

                    </ul>
                </li>
            </ul>

        </div>
    </div>
</nav>
