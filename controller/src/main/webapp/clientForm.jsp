<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Create a client</title>
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
        <div class="d11"><h2>Create a client</h2></div>
    <form name="add" method="post" action="client" autocomplete="off">
        <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
        <div class="form-inner">
            <div class="stripes-block"></div>
            <div class="form-row">
        Enter name: <label>
        <input name="name" type="text" required placeholder="Имя">
            </label> <br/></div>
                <div class="form-row">
        Enter surname: <label>
        <input name="surname" type="text" required placeholder="Фамилия">
    </label><br/></div>
                        <div class="form-row">
        Enter address: <label>
        <input name="address" type="text" required placeholder="Адрес">
    </label><br/></div>
            <div class="form-row">
        Enter phone: <label>
        <input name="phone" type="text" required placeholder="Телефон">
    </label><br/></div>
            <div class="form-row">
        Enter comment: <label>
        <input name="comment" type="text" required placeholder="Комментарий">
    </label><br/>
        <input name="action" type="hidden" value="add">
        <button class="floating-button">Create</button>

<div style="text-align: center;">
    <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
    <h2>Update Client: <%=request.getParameter("name")%> <%=request.getParameter("surname")%></h2>
    <form name="toUpdate" method="post" action="client" autocomplete="off">
        <input name="id" type="hidden" value="<%=Integer.parseInt(request.getParameter("id"))%>">
        <div class="form-inner">
            <div class="stripes-block"></div>
            <div class="form-row">
        Enter name: <label>
        <input name="name" type="text" value="<%=request.getParameter("name")%>">
            </label> <br/></div>
            <div class="form-row">
        Enter surname: <label>
        <input name="surname" type="text" value="<%=request.getParameter("surname")%>">
            </label> <br/></div>
            <div class="form-row">
        Enter address: <label>
        <input name="address" type="text" value="<%=request.getParameter("address")%>">
            </label> <br/></div>
            <div class="form-row">
        Enter phone: <label>
        <input name="phone" type="text" value="<%=request.getParameter("phone")%>">
            </label> <br/></div>
            <div class="form-row">
        Enter comment: <label>
        <input name="comment" type="text" value="<%=request.getParameter("comment")%>">
            </label> <br/>
        <input name="action" type="hidden" value="update">
        <button class="floating-button">Update</button>
<% }
    if (Objects.equals(request.getParameter("action"), "delete")) {%>
<h2>Delete <%=request.getParameter("name")%> <%=request.getParameter("surname")%> client </h2>
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
                        <input name="action" type="hidden" value="addRequestToClient">
                        <button class="floating-button">Create</button>
                        <div style="text-align: center;">
                                <%}%>
<a class="floating-button" href="client">Back</a>
</body>
</html>
