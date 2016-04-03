<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

    <c:choose>
        <c:when test="${book != null}">
        <table>
            <tr>
                <td>Film</td>
                <td>Session Date</td>
                <td>Seats</td>
                <td>Price</td>
            </tr>
            <c:forEach items="${book.seats}" var="seat">
                <tr>
                    <td>${seat.cinemaSession.filmName}</td>
                    <td><fmt:formatDate value="${seat.cinemaSession.sessionDate}" pattern="yyyy-MM-dd" /></td>
                    <td>${seat.seatNumber}</td>
                    <td>${seat.price}$</td>
                </tr>
            </c:forEach>
            <tr>
                <td>Total Price: ${book.ticketPrice}$</td>
            </tr>
            <tr>
                <td>Name: ${book.client.name}</td>
                <td>Surname: ${book.client.surName}</td>
            </tr>
            <tr>
                <td>Booking Number: ${book.bookNumber}</td>
            </tr>
            <tr>
                <td><a href="/">home</a></td>
            </tr>
        </table>
        </c:when>
        <c:otherwise>
            <h2>Booking not found. Try again</h2>
            <a href="/">home</a>
            <form name="findBooking" method="get" action="/findBooking">
                <input type="text" name="bookNumber"/>
                <input type="submit" value="search"/>
            </form>
        </c:otherwise>
    </c:choose>


<br/>
</body>
</html>
