<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
<h2>Choose day</h2>
<table>
    <form name="booking" method="post" action="sessions">
        <tr>
            <td>Date</td>
        </tr>
        <tr>
            <td><a href="sessions?date=04/03/16">03-APR-2015</a></td>
            <td><a href="sessions?date=04/02/16">02-APR-2015</a></td>
        </tr>
    </form>
    <tr>
        <td>Find Booking</td>
        <td><input id="bookingNumber" type="text" name="bookNumber"/></td>
        <td><button type="submit" onclick="findBookingInfo()"/>search</td>
    </tr>
    <div id="bookingInfo">

    </div>
</table>

<br/>

<script type="text/javascript">
    function findBookingInfo() {
        var bookingNumber = $('#bookingNumber').val();

        $.ajax({
            url: 'ajax/bookingInfo',
            type: 'get',
            data: 'bookingNumber='+bookingNumber,
            success : function(data) {
                $('#bookingInfo').html(data);
            }
        });
    }
</script>
</body>
</html>

