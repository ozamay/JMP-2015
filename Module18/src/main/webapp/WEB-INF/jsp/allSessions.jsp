<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>

<h2>List of Sessions</h2>
    <table>
        <tr>
            <td>Film</td>
            <td>Session Date</td>
            <td>Free Seats. Choose seats for booking </td>
        </tr>
    <form:form name="booking" method="post" commandName="client" action="booking">
        <input type="hidden" name="sessionDate" value="${sessionDate}"
        <c:forEach items="${sessions}" var="session">
            <tr>
                <td>${session.filmName}</td>
                <td><fmt:formatDate value="${session.sessionDate}" pattern="yyyy-MM-dd" /></td>
                <td>
                    <c:forEach var="detail" items="${session.cinemaSessionDetails}">
                        <c:if test="${detail.seatBooked == false}">
                            ${detail.seatID+1}
                            <input type="checkbox" name="seatsChose" value="${detail.cinemaSessionDetailID}" >
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>Name: <form:input path="name" rows="1"/></td>
            <td></td>
            <td>Surname: <form:input path="surName" rows="1"/></td>
        </tr>
        <tr>
            <td><form:errors path="name" class="error-message" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td><form:errors path="surName" class="error-message" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>${message}</td>
        </tr>
        <tr>
            <td><input  type="submit" value="Book"/></td>
        </tr>
    </form:form>
    </table>
<br/>

</body>


</html>
