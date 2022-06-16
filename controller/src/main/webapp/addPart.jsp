<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Add part to refrigerator</title>
  <style>
    body {
      background: papayawhip;
      color: slategrey;
      background-size: cover;
    }
  </style>
</head>
<body>
<div class="d11"><h2>Add part to refrigerator</h2></div>
<form name="addPartToRefrigerator" method="post" action="part" autocomplete="off">
  <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
  <div class="form-inner">
    <div class="stripes-block"></div>
    <div class="form-row">
      Enter name: <label>
      <input name="name" type="text" required placeholder="Name">
    </label> <br/></div>
    <div class="form-row">
      Enter price: <label>
      <input name="price" type="text" required placeholder="Price">
    </label><br/></div>
  </div>
  <input name="action" type="hidden" value="addPartToRefrigerator">
  <button class="floating-button">Create</button>
  <div style="text-align: center;">
  </div>
  <div style="text-align: center;">
    <a class="floating-button" href="refrigerator">Back</a>
  </div>
</body>
</html>
