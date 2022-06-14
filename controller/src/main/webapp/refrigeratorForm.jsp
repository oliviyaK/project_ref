<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Create a refrigerator</title>
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
    <div class="d11"><h2>Create a refrigerator</h2></div>
    <form name="add" method="post" action="refrigerator" autocomplete="off">
        <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
        <div class="form-inner">
            <div class="stripes-block"></div>
            <div class="form-row">
                Enter brand: <label>
                <input name="brand" type="text" required placeholder="Brand">
            </label> <br/></div>
            <div class="form-row">
                Enter model: <label>
                <input name="model" type="text" required placeholder="model">
            </label><br/></div>
            <div class="form-row">
                Enter comment: <label>
                <input name="comment" type="text" required placeholder="comment">
            </label><br/></div>
            <input name="action" type="hidden" value="add">
        </div>
            <button class="floating-button">Create</button>

            <div style="text-align: center;">
                <% } else if (Objects.equals(request.getParameter("action"), "update")) {%>
                <h2>Update a refrigerator: <%=request.getParameter("brand")%> <%=request.getParameter("model")%>
                </h2>
                <form name="toUpdate" method="post" action="refrigerator" autocomplete="off">
                    <input name="id" type="hidden" value="<%=Integer.parseInt(request.getParameter("id"))%>">
                    <div class="form-inner">
                        <div class="stripes-block"></div>
                        <div class="form-row">
                            Enter brand: <label>
                            <input name="brand" type="text" value="<%=request.getParameter("brand")%>"></label><br/>
                        </div>
                        <div class="form-row">
                            Enter model: <label>
                            <input name="model" type="text" value="<%=request.getParameter("model")%>"></label><br/>
                        </div>
                        <div class="form-row">
                            Enter comment: <label>
                            <input name="comment" type="text" value="<%=request.getParameter("comment")%>"></label>
                            <br/></div>
                        <div class="form-row">
                            <input name="action" type="hidden" value="update">
                            <button class="floating-button">Update</button>
                </form>
            </div>

                <% } %>
                <a class="floating-button" href="refrigerator">Back</a></div>  </div>
</body>
</html>
