<link href="css/caption.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Parts</title>
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
        <caption>Repair parts</caption>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Refrigerators</th>
        </tr>
<c:forEach var="part" items="${parts}">
    <tr>
    <td>${part.name}</td>
    <td>${part.price}</td>
    <td>
    <form name="delete" method="post" action="">
    <input name="id" type="hidden" value="${part.id}">
    <input name="action" type="hidden" value="delete">
    <button class="smallButton">Delete</button>
    </form>
    <form name="test" method="post" action="partForm.jsp">
    <input name="id" type="hidden" value="${part.id}">
    <input name="name" type="hidden" value="${part.name}">
    <input name="price" type="hidden" value="${part.price}">
    <input name="action" type="hidden" value="update">
    <button class="smallButton">Update</button>
    </form>
    </td>
    </tr>
</c:forEach>
    </table>
</div>
<div style="text-align: center;">
    <form name="test" action="partForm.jsp">
        <button class="floating-button">New item</button>
    </form>
    <form name="home" action="index.jsp">
        <button class="floating-button">Main Page</button>
    </form>
</div>
</body>
</html>
