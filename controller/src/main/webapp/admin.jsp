<%@ page import="refrigerator.entity.Refrigerator" %>
<%@ page import="DTO.OperatorDTO" %>
<%@ page import="static constants.Constant.OPERATOR_LIST" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 19.05.2022
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <link href="css/button-small.css" rel="stylesheet">
    <link href="css/button.css" rel="stylesheet">
    <style>
        h2 {
            font-size: xxx-large;
            font-family: Arial;
        }

        caption {
            font-family: Arial;
            font-size: xx-large;
        }

        td {
            font-size: xx-large;
            font-family: Arial, serif;
        }

        tr {
            font-size: xx-large;
            font-family: Arial, cursive;
        }

        body {
            background: linear-gradient(to top left, wheat, lightgoldenrodyellow);
            color: black;
            background-size: cover;
        }

        table {
            border: black;
        }
    </style>
</head>
<body>
<h2>Admin Service</h2>
<table border="6" width="50%">
    <caption><b>Admin Service</b></caption>
    <th>Operator</th>
    <th>Refrigerators</th>
    <th>Details</th>
<% List<OperatorDTO> operatorList =
        (List<OperatorDTO>) request.getAttribute(OPERATOR_LIST);
int i=1;
for (OperatorDTO operator: operatorList){
    %>
    <tr>
        <td><%= i++%></td>
        <td><%= operator.getName()%>
        </td>
        <td><%=operator.getClient()%>
        </td>
        <td><%= operator.getRequest()%>
        </td>
        <td><%= operator.getOperation()%>
        </td>
        <td>
            <form name="" method="post" action="">
                <input name="" type="hidden" value="<%=operator.getId()%>">
                <input name="action" type="hidden" value="enroll">
                <button class="floating-button">Operator</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>

<a class="floating-button" href="course">Управление Курсами</a>

<a class="floating-button" href="index.jsp">Главная страница</a>

<a class="floating-button" href="teacher">Информация об Учителях</a>

</body>
</html>