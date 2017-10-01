<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/26/17
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="head.jsp" />
    <body>
        <jsp:include page="header.jsp" />
<!-- Page Banner Start -->
        <div class="page-banner">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="breadcrumb-area">
                            <h2>Booking</h2>
                            <p>Whether you're looking to sell or let your home or want to buy or rent a home, we really are the people for you to come to.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Banner End -->

        <!-- Checkin Start -->
        <div class="shop-cart">
            <div class="container">
                <!--Checkout-->
                <h1 class="title">Booking</h1>
                <div class="row">
                    <!--Form-->
                    <form:form action="/orderCheckIn" method="post" modelAttribute="bookingDetails">
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <div class="shop-billing-fields">
                                <h3>Billing Details</h3>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Scmnd</label>
                                            <form:input path="bookingId.scmnd" type="text" class="input-text" name="Scmnd" id="scmnd" placeholder="Scmnd" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Full Name</label>
                                            <form:input path="bookingId.name" type="text" class="input-text" name="name" placeholder="Full Name" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Email Address</label>
                                            <form:input path="bookingId.email" type="text" class="input-text" name="email" placeholder="Email Address" value="" />
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Date of check-in</label>
                                            <form:input path="dateCheckIn" type="Date" class="input-text" name="dateCheckIn" placeholder="Checkin Date" value="" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <div class="shop-billing-fields">
                                <h3>
                                    <p>Have a coupon? <a href="#">Click here to enter your code</a></p>
                                </h3>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Date of check-out</label>
                                            <form:input path="dateCheckOut" type="Date" class="input-text" name="dateCheckOut" placeholder="CheckOut Date" value=""/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>How many adults</label>
                                            <form:input path="adultQuantity" type="text" class="input-text" name="adultQuantity" placeholder="Adult Quantity" value=""/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>How many child</label>
                                            <form:input path="childrenQuantity" type="text" class="input-text" name="childrenQuantity" placeholder="Phone Number" value=""/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>Room Name</label>
                                            <form:input path="roomId.name" type="text" class="input-text" name="roomName" placeholder="Room Name" value=""/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <br>
                                        <div class="form-group Btn">
                                            <input type="submit" name="submit" class="btn-submit" value="submit now">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <!-- Checkin End -->

        <jsp:include page="footer.jsp" />
        <jsp:include page="scrip.jsp" />
    </body>
</html>

