<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <jsp:include page="head.jsp"/>


    </head>
    <body>
        <div id="wrapper">


            <!-- Navigation -->
            <jsp:include page="nav.jsp"/>
            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">THỐNG KÊ</h1>
                            <ol class="breadcrumb">
                                <li class="active">
                                    <i></i> Quản trị
                                </li>
                            </ol>
                        </div>
                    </div>

                    <div class="row">
                        <div id="chart" style="min-width:310px; height: 400px; margin: 0 auto"></div>
                    </div>
                </div>
            </div>

        </div>
        <jsp:include page="footer.jsp"/>

        <script src="/resources/js/highcharts.js"></script>
        <script src="/resources/js/exporting.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script type="text/javascript">
            $(function () {
                var chart = new Highcharts.chart('chart', {

                    title: {
                        text: 'the hotel statistics growth on year, 2010-2016'
                    },

                    subtitle: {
                        text: 'Source: thesolarfoundation.com'
                    },

                    yAxis: {
                        title: {
                            text: 'Number of Hotel'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle'
                    },

                    plotOptions: {
                        series: {
                            pointStart: 2010
                        }
                    },

                    series: [{
                        name: 'Installation',
                        data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
                    }, {
                        name: 'Manufacturing',
                        data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
                    }, {
                        name: 'Sales & Distribution',
                        data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
                    }, {
                        name: 'Project Development',
                        data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
                    }, {
                        name: 'Other',
                        data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
                    }],

                    responsive: {
                        rules: [{
                            condition: {
                                maxWidth: 500
                            },
                            chartOptions: {
                                legend: {
                                    layout: 'horizontal',
                                    align: 'center',
                                    verticalAlign: 'bottom'
                                }
                            }
                        }]
                    }

                });
            });
        </script>
    </body>
</html>
