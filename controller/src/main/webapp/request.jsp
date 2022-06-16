<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/caption.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<html>
<head>
    <title>Requests</title>
</head>
<style>
    body {
        margin: 0;
        height: 100vh;
        background: radial-gradient(#FAECD5 15%, transparent 15%), radial-gradient(#ABB93F 15%, transparent 15%);
        background-color: #CAE4D8;
        background-size: 30px 30px;
        background-position: 0 0, 20px 20px;
    }

    p {
        color: #FFF;
        font: 15px Lobster;
    }
</style>
<body>
<div style="text-align: center;">
    <table>
        <caption>Your requests</caption>
        <tr>
            <th>Date</th>
            <th>Type of request</th>
            <th>Action</th>
            <th>Request info</th>
        </tr>
        <c:forEach var="request" items="${requests}">
            <tr>
                <td>${request.date}</td>
                <td>${request.requestType}</td>
                <td>
                    <form name="delete" method="post" action="">
                        <input name="id" type="hidden" value="${request.id}">
                        <input name="action" type="hidden" value="delete">
                        <button class="smallButton">Delete</button>
                    </form>
                    <form name="test" method="post" action="requestForm.jsp">
                        <input name="id" type="hidden" value="${request.id}">
                        <input name="date" type="hidden" value="${request.date}">
                        <input name="requestType" type="hidden" value="${request.requestType}">
                        <input name="action" type="hidden" value="update">
                        <button class="smallButton">Update</button>
                    </form>
                    <form action="addRefrigerator.jsp">
                        <input name="id" type="hidden" value="${request.id}">
                        <button class="smallButton">Add refrigerator</button>
                    </form>
                </td>
                <td>
                    <form name="info" method="post" action="requestInfo.jsp">
                        <input name="id" type="hidden" value="${request.id}">
                        <input name="date" type="hidden" value="${request.date}">
                        <input name="requestType" type="hidden" value="${request.requestType}">
                        <input name="clientName" type="hidden" value="${request.client.name}">
                        <input name="clientSurname" type="hidden" value="${request.client.surname}">
                        <input name="clientAddress" type="hidden" value="${request.client.address}">
                        <input name="clientPhone" type="hidden" value="${request.client.phone}">
                        <input name="clientComment" type="hidden" value="${request.client.comment}">
                        <button class="smallButton">Client details</button>
                    </form>
                    <form name="info" method="post" action="refrigeratorInfo.jsp">
                        <input name="id" type="hidden" value="${request.id}">
                        <input name="date" type="hidden" value="${request.date}">
                        <input name="requestType" type="hidden" value="${request.requestType}">
                        <input name="refrigeratorBrand" type="hidden" value="${request.refrigeratorBrand}">
                        <input name="refrigeratorModel" type="hidden" value="${request.refrigeratorModel}">
                        <button class="smallButton">Refrigerator details</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="text-align: center;">
    <form name="test" action="requestForm.jsp">
        <button class="floating-button">New Request</button>
    </form>
    <form name="home" action="index.jsp">
        <button class="floating-button">Main Page</button>
    </form>
</div>
</body>
</html>
