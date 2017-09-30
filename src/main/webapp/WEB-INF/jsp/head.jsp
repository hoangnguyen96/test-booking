<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 09/20/17
  Time: 5:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Hotel Empire - Hotel Reservation HTML Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">

    <!-- External CSS libraries -->
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/slider.css">
    <link rel="stylesheet" href="/resources/css/flatpickr.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/font-awesome-4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/flaticon/font/flaticon.css">

    <!-- Custom stylesheet -->
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <!-- Google fonts -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800%7CPlayfair+Display:400,700%7CRoboto:100,300,400,400i,500,700">

    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <script src="/resources/js/ie-emulation-modes-warning.js"></script>
    <script>
        $( function() {
            //$( "#datepicker" ).datepicker({ maxDate: new Date(2016, 12, 12), minDate: new Date(2016, 10, 15) });

            // Date for the future 1 year can be done by
            $( "#datepicker" ).datepicker({dateFormat: 'yy-mm-dd', minDate:(0), maxDate:(365)});
        } );
    </script>
</head>
