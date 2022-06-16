<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 22.05.2022
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator's page</title>
</head>
<link href="css/button.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<style>
    title {
        font-style: normal;
    }
    body {
        background: url("operator.jpg");
        color: black;
        background-size: cover;
    }
</style>
<body>
<nav class="one">
<ul class="topmenu">
    <li><a class="floating-button" href="client">Clients<i class="fa fa-angle-down"></i></a>
        <ul class="submenu">
            <li><a href="clientForm.jsp">Create a client</a></li>

        </ul>
    </li>
    <li><a class="floating-button" href="request">Requests<i class="fa fa-angle-down"></i></a>
        <ul class="submenu">
            <li><a href="requestForm.jsp">Create a request</a></li>

        </ul>
    </li>
    <li><a class="floating-button" href="operation">Operations<i class="fa fa-angle-down"></i></a>
        <ul class="submenu">
            <li><a href="operationForm.jsp">Create operation</a></li>

        </ul>
    </li>
    <li><a class="floating-button" href="refrigerator">Refrigerators<i class="fa fa-angle-down"></i></a>
        <ul class="submenu">
            <li><a href="refrigeratorForm.jsp">Create refrigerator</a></li>

        </ul>
    </li>
    <li><a class="floating-button" href="part">Parts<i class="fa fa-angle-down"></i></a>
        <ul class="submenu">
            <li><a href="partForm.jsp">Create a part</a></li>

        </ul>
    </li>

</ul>
</nav>


</body>
</html>
