<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/28/17
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <jsp:include page="head.jsp"/>
</head>
<body>

<div id="wrapper">

    <jsp:include page="nav.jsp" />

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><small>Quản lý Rooms</small></h1>
                    <ol class="breadcrumb">
                        <li >
                            <i></i><a href="/admin">Quản lý</a></i>
                        </li>
                        <li class="active">
                            <i>Rooms</i>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 add-search">
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <form action="searchRoom" method="get">
                            <div class="input-group">
                                <input name="searchInput" type="text" class="form-control" placeholder="Search by name or author..."/>
                                <span class="input-group-btn">
                                            <button class="btn btn-primary" type="submit">Search</button>
                                        </span>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-2 col-md-4">
                        <a href="/upload"><button type="button" class="btn btn-lg btn-success" >Add Room</button></a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped" id="dataTable">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>AdultPrice</th>
                                <th>ChildrenPrice</th>
                                <th>RoomType</th>
                                <th>Photo</th>
                                <th colspan="2"></th>
                            </tr>
                            </thead>
                            <tbody id="content11">

                            <c:forEach var="room" items="${roomList}" >
                                <tr>
                                    <td>${room.name}</td>
                                    <td>${room.adultPrice}</td>
                                    <td>${room.childrenPrice}</td>
                                    <td>${room.roomTypeId.name}</td>
                                    <td>${room.photo}</td>
                                    <td>
                                        <button class="btn btn-danger" onclick="location.href='deleted/${room.id}'">Delete</button>
                                        <button class="btn btn-primary" onclick="location.href='edit/${room.id}'">Edit</button>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                            <tr>
                                <td colspan="6" align="center">
                                </td>

                            </tr>
                        </table>

                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<jsp:include page="footer.jsp"/>

</body>
</html>
