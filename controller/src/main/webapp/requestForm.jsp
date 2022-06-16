<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Create a request</title>
    <style>
        body {
            background: papayawhip;
            color: slategrey;
            background-size: cover;
        }
    </style>
</head>
<body>
<div id="left">
        <% if (request.getParameter("id") == null) { %>
    <div class="d11"><h2>Create a request</h2></div>
    <form name="add" method="post" action="request" autocomplete="off">
        <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
        <form class="form-inner">
            <div class="stripes-block"></div>
            <div class="form-row">
                Enter date: <label>
                <input name="date" type="date" required placeholder="Дата">
            </label> <br/></div>
            <div class="form-row">
                Enter type of request: <label>
                <input name="requestType" type="text" required placeholder="Заявка">
            </label><br/></div>
            <input name="action" type="hidden" value="add">
            <button class="floating-button">Create</button>
            <div style="text-align: center;">
                    <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
                <h2>Update a request: <%=request.getParameter("id")%>
                </h2>
                <form name="toUpdate" method="post" action="request" autocomplete="off">
                    <input name="id" type="hidden" value="<%=Integer.parseInt(request.getParameter("id"))%>">
                    <form class="form-inner">
                        <div class="stripes-block"></div>
                        <div class="form-row">
                            Enter date: <label>
                            <input name="date" type="date" value="<%=request.getParameter("date")%>"> </label><br/>
                        </div>
                        <div class="form-row">
                            Enter type of request: <label>
                            <input name="requestType" type="text" value="<%=request.getParameter("requestType")%>">
                        </label><br/>
                            <input name="action" type="hidden" value="update"></div>
                    </form>
                    <button class="floating-button">Update</button>
                    <div style="text-align: center;">
                            <% } else if (Objects.equals(request.getParameter("action"), "delete")) {%>
                        <h2>Delete <%=request.getParameter("id")%> request</h2>
                        <form name="toDelete" method="post" action="" autocomplete="off">
                            <input name="action" type="hidden" value="delete">
                            <button>Удалить</button>
                        </form>
                            <% } else if (request.getParameter("id") != null) { %>
                        <div class="d11"><h2>Create a client's request</h2></div>
                        <form name="addRequestToClient" method="post" action="request" autocomplete="off">
                            <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
                            <div class="form-inner">
                                <div class="stripes-block"></div>
                                <div class="form-row">
                                    Enter date: <label>
                                    <input name="date" type="date" required placeholder="Дата">
                                </label> <br/></div>
                                <div class="form-row">
                                    Enter type of request: <label>
                                    <input name="requestType" type="text" required placeholder="Заявка">
                                </label><br/></div>
                            </div>
                            <input name="action" type="hidden" value="addRequestToClient">
                            <button class="floating-button">Create</button>
                                <%}%>
                            <div style="text-align: center;">
                            </div>
                            <div style="text-align: center;">
                                <a class="floating-button" href="request">Back</a></div>

</body>
</html>
