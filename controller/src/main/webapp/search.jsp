<%@ page import="refrigerator.entity.Request" %><%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 17.05.2022
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<table>

    <form name="test" method="post" action="client">
        ID: <input name="id" type="text" value="Id">
        <input name="action" type="hidden" value="search">
        <button>Search</button>
    </form>
    <br>
    <% Request request1 = (Request) request.getAttribute("request");%>
    <%=request1 %>
</table>
</body>
</html>
