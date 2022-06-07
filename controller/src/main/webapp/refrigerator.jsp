<link href="css/caption.css" rel="stylesheet">
<link href="css/table.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<link href="css/button.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Refrigerators</title>
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
        <caption>Refrigerator list</caption>
        <tr>
            <th>Brand</th>
            <th>Model</th>
            <th>Comment</th>
         <th>Part info</th>
        </tr>
<c:forEach var="client" items="${refrigerators}">
    <tr>
    <td>${refrigerator.brand}</td>
    <td>${refrigerator.model}</td>
    <td>${refrigerator.comment}</td>
    <td>
    <form name="delete" method="post" action="">
    <input name="id" type="hidden" value="${refrigerator.id}">
    <input name="action" type="hidden" value="delete">
    <button class="smallButton">Delete</button>
    </form>
    <form name="test" method="post" action="refrigeratorForm.jsp">
    <input name="id" type="hidden" value="${refrigerator.id}">
    <input name="brand" type="hidden" value="${refrigerator.brand}">
    <input name="model" type="hidden" value="${refrigerator.model}">

    <input name="address" type="hidden" value="${client.address}">
    <input name="phone" type="hidden" value="${client.phone}">
    <input name="comment" type="hidden" value="${client.comment}">
    <input name="action" type="hidden" value="update">
    <button class="smallButton">Update</button>
</body>
</html>
