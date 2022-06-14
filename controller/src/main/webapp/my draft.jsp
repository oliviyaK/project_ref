else if (request.getParameter("id") != null){ %>
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
  <div style="text-align: center;"> <%}


  refrigeratorForm,jsp
 <%--   <% } else if (Objects.equals(request.getParameter("action"), "delete")) {%>--%>
    <%--                    <h2>Delete refrigerator</h2>--%>
    <%--                    <form name="toDelete" method="post" action="" autocomplete="off">--%>
    <%--                        <input name="action" type="hidden" value="delete">--%>
    <%--                        <button>Удалить</button>--%>
<%--                    </form>--%>