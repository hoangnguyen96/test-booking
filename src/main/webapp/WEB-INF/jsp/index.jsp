<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp"/>
    <body>
        <div id="demo-1" data-zs-src='["images/hotel.jpg", "images/hotel6.jpg", "images/hotel3.jpg","images/hotel1.jpg"]'
             data-zs-overlay="dots">
            <div class="demo-inner-content">
                <!--/header-w3l-->
                <div class="header-w3-agileits" id="home">
                    <jsp:include page="header.jsp"/>

                    <!--//header-w3l-->
                    <!--/banner-info-->
                    <div class="baner-info">
                        <h3>Wel<span>Come </span>To <span>Empire </span> Hotel</h3>

                        <div class="container">
                            <form action="route/search-bus-line" method="post">

                                <div class=" mb-3 col-lg-3">
                                    <div class="form-group">
                                        <input class="form-control" id="checkin" type="Date" placeholder="Checkin Date">
                                    </div>
                                </div>
                                <div class="col-lg-3">
                                    <div class="form-group">
                                        <input type="date" class="form-control" placeholder="Chọn ngày" name="date">
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <select class="form-control" id="room">
                                            <option>Choose Room</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <select class="form-control" id="guest">
                                            <option>Choose Guest</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>6</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-2">
                                    <div class="form-group">
                                        <input type="submit" class="form-control btn btn-danger" value="Check Availability">

                                    </div>
                                </div>

                            </form>
                        </div>
                        <p>Enjoy Your Stay In</p>
                    </div>
                    <!--/banner-ingo-->

                </div>
            </div>
        </div>
        <!-- services -->
        <div class="breadcrumb-inner">

        </div>
        <div class="container">
            <div class="inner-agile-w3l-part-head">
                <h2 class="w3l-inner-h-title">Favorite Rooms</h2>
            </div>
            <div class="w3_agileits_services_grids">
                <div class="col-md-3 w3_agileits_services_grid hvr-overline-from-center">
                    <div class="w3_agileits_services_grid_agile">
                        <div class="w3_agileits_services_grid_1">
                            <img src="/resources/img/5.jpg" alt="service-img">
                        </div>
                        <h3>Deluxe Room</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                    </div>
                </div>
                <div class="col-md-3 w3_agileits_services_grid hvr-overline-from-center">
                    <div class="w3_agileits_services_grid_agile">
                        <div class="w3_agileits_services_grid_1">
                            <img src="/resources/img/6.jpg" alt="service-img">
                        </div>
                        <h3>Luxury Room</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                    </div>
                </div>
                <div class="col-md-3 w3_agileits_services_grid hvr-overline-from-center">
                    <div class="w3_agileits_services_grid_agile">
                        <div class="w3_agileits_services_grid_1">
                            <img src="/resources/img/7.jpg" alt="service-img">
                        </div>
                        <h3>Swimming Pool</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                    </div>
                </div>
                <div class="col-md-3 w3_agileits_services_grid hvr-overline-from-center">
                    <div class="w3_agileits_services_grid_agile">
                        <div class="w3_agileits_services_grid_1">
                            <img src="/resources/img/8.jpg" alt="service-img">
                        </div>
                        <h3>Spa Care</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--/banner-section-->
        <div class="w3_breadcrumb">
            <div class="breadcrumb-inner">

            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
