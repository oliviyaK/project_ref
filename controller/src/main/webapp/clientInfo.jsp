<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<link href="css/button.css" rel="stylesheet">
<link href="css/caption.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Client Details</title>
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
</head>
<body>
<div style="text-align: center;">
    <table>
        <tr>
<th>Name</th>
<th>Surname</th>
<th>Address</th>
<th>Phone</th>
<th>Comment</th>
<th>Request info</th>
        </tr>
        <tr>
            <td>${param.name}</td>
            <td>${param.surname}</td>
            <td>${param.address}</td>
            <td>${param.phone}</td>
            <td>${param.comment}</td>
            <td>${param.requestOfClient}</td>
        </tr>
    </table>
    <form name="test" action="client">
        <button class="floating-button">Back</button>
    </form>
    <form name="test" action="index.jsp">
        <button class="floating-button">Main page</button>
    </form>
</div>
</body>
</html>
