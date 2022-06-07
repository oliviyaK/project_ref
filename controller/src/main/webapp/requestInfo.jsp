
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
    <title>Request Details</title>
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
        <th>Date</th>
        <th>Type of request</th>
        <th>Client Info</th>
    </tr>

    <tr>
        <td>${param.date}</td>
        <td>${param.requestType}</td>
        <td>${param.client}</td>
    </tr>

</table>
    <form name="test" action="request">
        <button class="floating-button">Back</button>
    </form>
    <form name="test" action="index.jsp">
        <button class="floating-button">Main page</button>
    </form>
</div>
</body>
</html>
