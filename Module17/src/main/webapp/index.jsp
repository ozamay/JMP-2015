<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
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
    <form name="findBooking" method="get" action="/findBooking">
        <tr>
            <td>Find Booking</td>
            <td><input type="text" name="bookNumber"/></td>
            <td><input type="submit" value="search"/></td>
        </tr>
    </form>
</table>
<br/>
</body>
</html>

