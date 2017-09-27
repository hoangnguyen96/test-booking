<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 11:19 PM
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
                            <h1 class="page-header"><small>Quản lý User</small></h1>
                            <ol class="breadcrumb">
                                <li >
                                    <i></i><a href="/admin">Quản lý</a></i>
                                </li>
                                <li class="active">
                                    <i>User</i>
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 add-search">
                            <div class="col-xs-12 col-sm-8 col-md-6">
                                <form:form action="search" method="get">
                                    <div class="input-group">
                                        <input name="searchInput" type="text" class="form-control" placeholder="Search by name or author..."/>
                                        <span class="input-group-btn">
                                            <button class="btn btn-primary" type="submit">Search</button>
                                        </span>
                                    </div>
                                </form:form>
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
                                        <th>Scmnd</th>
                                        <th>Address</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Sex</th>
                                        <th>Role</th>
                                        <th colspan="2"></th>
                                    </tr>
                                    </thead>
                                    <tbody id="content11">

                                    <c:forEach var="user" items="${userList}" >
                                        <tr>
                                            <td>${user.name}</td>
                                            <td>${user.scmnd}</td>
                                            <td>${user.address}</td>
                                            <td>${user.email}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.sex}</td>
                                            <td>${user.roleEntity.name}</td>
                                            <td>
                                                <button class="btn btn-danger" onclick="location.href='delete/${user.id}'">Delete</button>
                                            </td>
                                        </tr>
                                    </c:forEach>


                                    </tbody>

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