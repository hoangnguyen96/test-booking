<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/28/17
  Time: 1:36 PM
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
                            <i>Phòng</i>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                    <form:form action="/upload" modelAttribute="roomEntity" cssStyle="margin-left: 340px;" class="form-horizontal" enctype="multipart/form-data" method="post" >
                        <div style="margin-bottom: 50px;padding-left: 111px;"><h1>Quản lý phòng</h1></div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Tên phòng:</label>
                            <div class="col-sm-4">
                                <form:input type="text" class="form-control" path="name" name="name" placeholder="Nhập tên" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Giá người lớn:</label>
                            <div class="col-sm-4">
                                <form:input type="text" class="form-control" path="adultPrice" name="adultPrice" placeholder="Giá người lớn" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Giá trẻ em:</label>
                            <div class="col-sm-4">
                                <form:input type="text" class="form-control" path="childrenPrice" name="childrenPrice" placeholder="Giá trẻ em" required="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Loại phòng:</label>
                            <div class="col-sm-4">
                                <form:select path="roomTypeId.id" class="form-control">
                                    <form:option value="0" label="--- Select ---" />
                                    <form:options items="${roomType}" />
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Hình ảnh:</label>
                            <div class="col-sm-4">
                                <input type="file" name="file" class="form-control" placeholder="Chọn file"/>
                            </div>
                        </div>

                        <div style="padding-left: 140px;margin-bottom: 200px;" class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Add room</button>
                            </div>
                        </div>
                    </form:form>

            </div>
        </div>
    </div>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<jsp:include page="footer.jsp"/>

</body>
</html>



