<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/01/17
  Time: 7:04 PM
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
                    <h1 class="page-header"><small>Quản lý Order</small></h1>
                    <ol class="breadcrumb">
                        <li >
                            <i></i><a href="/admin">Quản lý</a></i>
                        </li>
                        <li class="active">
                            <i>Order</i>
                        </li>
                    </ol>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped" id="dataTable">
                            <thead>
                            <tr>
                                <th>Scmnd</th>
                                <th>Name</th>
                                <th>Email Address</th>
                                <th>Date CheckIn</th>
                                <th>Date CheckOut</th>
                                <th>Adult Quantity</th>
                                <th>Children Quantity</th>
                                <th>Name Room</th>
                                <th colspan="2"></th>
                            </tr>
                            </thead>
                            <tbody id="content11">

                            <c:forEach var="booking" items="${bookingList}" >
                                <tr>
                                    <td>${booking.bookingId.scmnd}</td>
                                    <td>${booking.bookingId.name}</td>
                                    <td>${booking.bookingId.email}</td>
                                    <td>${booking.dateCheckIn}</td>
                                    <td>${booking.dateCheckOut}</td>
                                    <td>${booking.adultQuantity}</td>
                                    <td>${booking.childrenQuantity}</td>
                                    <td>${booking.roomId.name}</td>
                                    <td>
                                        <button class="btn btn-danger" onclick="location.href='delete/${booking.id}'">Delete</button>
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>
                            <tr>
                                <td colspan="9" align="center">
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
