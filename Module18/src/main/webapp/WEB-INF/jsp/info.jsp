<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
    <c:when test="${booking != null}">
        <table>
            <tr>
                <td>Film</td>
                <td>Session Date</td>
                <td>Seats</td>
                <td>Price</td>
            </tr>
            <c:forEach items="${bookingInfoDTOs}" var="dto">
                <tr>
                    <td>${dto.cinemaSession.filmName}</td>
                    <td><fmt:formatDate value="${dto.cinemaSession.sessionDate}" pattern="yyyy-MM-dd" /></td>
                    <td>${dto.seat.seatNumber}</td>
                    <td>${dto.seat.price}$</td>
                </tr>
            </c:forEach>
            <tr>
                <td>Total Price: ${booking.ticketPrice}$</td>
            </tr>
            <tr>
                <td>Name: ${client.name}</td>
                <td>Surname: ${client.surName}</td>
            </tr>
            <tr>
                <td>Booking Number: ${booking.bookingNumber}</td>
            </tr>
        </table>
    </c:when>
    <c:otherwise>
        <h2>Booking not found. Try again</h2>
    </c:otherwise>
</c:choose>