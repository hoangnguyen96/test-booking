<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 11:20 PM
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
                    <h1 class="page-header"><small>Quản lý Hotel</small></h1>
                    <ol class="breadcrumb">
                        <li >
                            <i></i><a href="/admin">Quản lý</a></i>
                        </li>
                        <li class="active">
                            <i >Hotel</i>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 add-search">
                    <div class="col-lg-2 col-md-6">

                    </div>
                    <div class="col-lg-6 col-md-6">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>Số điện thoại</th>
                                <th>Tên </th>
                                <th>Địa chỉ</th>
                                <th>Người đại diện</th>
                                <th>Cho phép</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody id="content11">

                            </tbody>
                            <tr>
                                <td colspan="7" align="center">
                                    <ul class="pagination">
                                    </ul>
                                </td>

                            </tr>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
