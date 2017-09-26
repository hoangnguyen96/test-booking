<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/26/17
  Time: 4:37 PM
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
                    <!-- Form Content Box Start -->
                    <div class="form-content-box">
                        <div class="details">
                            <h2>CẬP NHẬT THÔNG TIN</h2>

                            <form:form modelAttribute="user" action="update" method="post" role="form" data-toggle="validator">

                                <div class="form-group">
                                    <label for="scmnd">Số cmnd: </label>
                                    <form:input path="scmnd" required="true" type="text" class="form-control" name="scmnd" id="scmnd" />
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail" class="control-label">Email: </label>
                                    <form:input path="email" type="email" required="true" class="form-control" name="email" id="inputEmail" />
                                </div>
                                <div class="form-group">
                                    <label for="fullname">Họ và tên: </label>
                                    <form:input path="name" required="true" type="text" class="form-control" name="name" id="fullname" />
                                </div>
                                <div class="form-group">
                                    <label >Giới tính: </label>
                                    <form:select path="sex" name="sex" class="form-control" >
                                        <form:options items="${getSex}"/>
                                    </form:select>
                                </div>
                                <div class="form-group">
                                    <label for="inputAddress"  class="control-label">Địa chỉ: </label>
                                    <form:input path="address" required="true" data-minlength="6" type="address" class="form-control"  name="address" id="inputAddress" />
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="sodienthoai">Số điện thoại: </label>
                                    <form:input path="phone" required="true" type="text" class="form-control" name="phone" id="sodienthoai" />
                                </div>
                                <input type="submit" class="submit"  id="btn-register" value="Thực hiện">
                            </form:form>

                        </div>
                        <!-- Footer -->
                        <div class="footer">
                                    <span>
                                        Already have an account? <a href="/login">Log in</a>
                                    </span>
                        </div>
                    </div>
                    <!-- Form Content Box End -->
                </div>
            </div>
        </div>
        <jsp:include page="scrip.jsp" />
    </body>
</html>
