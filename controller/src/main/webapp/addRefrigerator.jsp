<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/button.css" rel="stylesheet">
<link href="css/clientCard.css" rel="stylesheet">
<link href="css/create.css" rel="stylesheet">
<html>
<head>
    <title>Add refrigerator to request</title>
  <style>
    body {
      background: papayawhip;
      color: slategrey;
      background-size: cover;
    }
  </style>
</head>
<body>
<div class="d11"><h2>Add refrigerator to request</h2></div>
<form name="addRefrigeratorsToRequest" method="post" action="refrigerator" autocomplete="off">
  <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
  <div class="form-inner">
    <div class="stripes-block"></div>
    <div class="form-row">
      Enter brand: <label>
      <input name="brand" type="text" required placeholder="Бренд">
    </label> <br/></div>
    <div class="form-row">
      Enter model: <label>
      <input name="model" type="text" required placeholder="Модель">
    </label><br/></div>
    <div class="form-row">
    Enter comment: <label>
    <input name="comment" type="text" required placeholder="Комментарий">
  </label><br/></div>
  </div>
    <input name="action" type="hidden" value="addRefrigeratorsToRequest">
    <button class="floating-button">Create</button>
    <div style="text-align: center;">
    </div>
    <div style="text-align: center;">
      <a class="floating-button" href="request">Back</a>
    </div>
</body>
</html>
