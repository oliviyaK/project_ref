<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Create a part</title>
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
    <div class="d11"><h2>Create a part</h2></div>
    <form name="add" method="post" action="part" autocomplete="off">
        <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
        <div class="form-inner">
            <div class="stripes-block"></div>
            <div class="form-row">
                Enter name: <label>
                <input name="name" type="text" required placeholder="name">
            </label> <br/></div>
            <div class="form-row">
                Enter price: <label>
                <input name="price" type="text" required placeholder="price">
            </label><br/></div>
            <div class="form-row">
            <input name="action" type="hidden" value="add">
        </div>
        <button class="floating-button">Create</button>
            <div style="text-align: center;">
                <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
                <h2>Update a refrigerator: <%=request.getParameter("name")%></h2>
                <form name="toUpdate" method="post" action="part" autocomplete="off">
                    <input name="id" type="hidden" value="<%=Integer.parseInt(request.getParameter("id"))%>">
                    <div class="form-inner">
                        <div class="stripes-block"></div>
                        <div class="form-row">
                            Enter name: <label>
                            <input name="name" type="text" value="<%=request.getParameter("name")%>"></label><br/>
                        </div>
                        <div class="form-row">
                            Enter price: <label>
                            <input name="price" type="text" value="<%=request.getParameter("price")%>"></label><br/>
                        </div>
                        <div class="form-row">
                            <input name="action" type="hidden" value="update">
                            <button class="floating-button">Update</button>
                </form>
            </div>
            <% } %>
            <a class="floating-button" href="part">Back</a></div>  </div>
</body>
</html>
