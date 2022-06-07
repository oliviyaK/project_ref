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
    <title>Clients</title>
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
    <caption>Your clients</caption>
    <tr>
<th>Name</th>
<th>Surname</th>
<th>Address</th>
<th>Phone</th>
<th>Comment</th>
<th>Action</th>
<th>Request info</th>
    </tr>
<c:forEach var="client" items="${clients}">
    <tr>
    <td>${client.name}</td>
    <td>${client.surname}</td>
    <td>${client.address}</td>
    <td>${client.phone}</td>
    <td>${client.comment}</td>
    <td>
    <form name="delete" method="post" action="">
    <input name="id" type="hidden" value="${client.id}">
    <input name="action" type="hidden" value="delete">
    <button class="smallButton">Delete</button>
    </form>
    <form name="test" method="post" action="clientForm.jsp">
    <input name="id" type="hidden" value="${client.id}">
    <input name="name" type="hidden" value="${client.name}">
    <input name="surname" type="hidden" value="${client.surname}">
    <input name="address" type="hidden" value="${client.address}">
    <input name="phone" type="hidden" value="${client.phone}">
    <input name="comment" type="hidden" value="${client.comment}">
    <input name="action" type="hidden" value="update">
    <button class="smallButton">Update</button>
    </form>

        <form action="requestForm.jsp">
            <input name="id" type="hidden" value="${client.id}">
            <button class="smallButton">Add request</button>
        </form>
    </td>
<%--        <td>--%>
<%--            <form name="info" method="post" action="request">--%>
<%--                <input name="id" type="hidden" value="${requestList.id}">--%>
<%--                <button class="smallButton"><a href="requestInfo.jsp?id=${request.id}&date=${request.date}&requestType=${request.requestType}--%>
<%--                    &client=${request.client}">Инфо</a></button>--%>
<%--            </form>--%>
<%--        </td>--%>
    </tr>
</c:forEach>
</table>
</div>
    <div style="text-align: center;">
    <form name="test" action="clientForm.jsp">
    <button class="floating-button">New Client</button>
    </form>
    <form name="home" action="index.jsp">
    <button class="floating-button">Main Page</button>
    </form>
    </div>
    </body>
    </html>