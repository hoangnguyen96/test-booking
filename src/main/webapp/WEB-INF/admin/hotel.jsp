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
                    <h1 class="page-header"><small>Quản lý Nhà xe</small></h1>
                    <ol class="breadcrumb">
                        <li >
                            <i></i><a href="/admin">Quản lý</a></i>
                        </li>
                        <li class="active">
                            <i >Nhà xe</i>
                        </li>
                    </ol>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12 add-search">
                    <div class="col-lg-2 col-md-6">

                    </div>
                    <div class="col-lg-6 col-md-6">
                        <%--<form:form action="busprovider/search" method="get">--%>
                            <%--<div class="input-group search">--%>
                                <%--<input name="searchInput" type="text" class="form-control" placeholder="Tìm kiếm...">--%>
                                <%--<span class="input-group-btn">--%>
                                        <%--<button class="btn btn-primary" type="submit">--%>
                                            <%--<i class="fa fa-search"></i>--%>
                                        <%--</button>--%>
                                    <%--</span>--%>
                            <%--</div>--%>
                        <%--</form:form>--%>
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
                                <th>Tên nhà xe</th>
                                <th>Địa chỉ</th>
                                <th>Người đại diện</th>
                                <th>Cho phép</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody id="content11">
                            <%--<c:forEach var="busprovider" items="${busProviderList}" >--%>
                                <%--<tr>--%>
                                    <%--<td>${busprovider.mobilePhone}</td>--%>
                                    <%--<td>${busprovider.name}</td>--%>
                                    <%--<td>${busprovider.proAddress}</td>--%>
                                    <%--<td>${busprovider.representer}</td>--%>
                                    <%--<td>--%>
                                        <%--<c:choose>--%>
                                            <%--<c:when test="${busprovider.allowed==false}">--%>
                                                <%--<a class="btn btn-primary" href="/provider/excute/${busprovider.id}">--%>
                                                    <%--<b class="fa fa-check-square-o"></b></a>--%>
                                            <%--</c:when>--%>
                                            <%--<c:otherwise>--%>
                                                <%--<a class="btn btn-primary" disabled="true" href="/provider/excute/${busprovider.id}">--%>
                                                    <%--<b class="fa fa-check-square-o"></b></a>--%>
                                            <%--</c:otherwise>--%>
                                        <%--</c:choose>--%>
                                    <%--</td>--%>
                                    <%--<td><a href="/provider/delete/${busprovider.id}" class="btn btn-danger" ><b class="fa fa-trash-o"></b></a></td>--%>
                                <%--</tr>--%>
                            <%--</c:forEach>--%>

                            </tbody>
                            <script>
                                $(document).ready(function(){
                                    $(".page").click(function(){
                                        var url =$(this).val();
                                        $(".page").prop("disabled",false);
                                        $(this).prop("disabled",true);
                                        $.ajax({
                                            url: url, success: function(data){
                                                $("#content11").html(data);
                                            }
                                        });
                                    });
                                });
                            </script>
                            <tr>
                                <td colspan="7" align="center">
                                    <ul class="pagination">
                                ///
                                        <%--<c:forEach var="item" begin="1" end="${total}">--%>
                                            <%--<li >--%>
                                                <%--<button class="page btn btn-success" value="/admin/getbusprovider?page=${item}">${item}</button>--%>
                                            <%--</li>--%>
                                        <%--</c:forEach>--%>

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
