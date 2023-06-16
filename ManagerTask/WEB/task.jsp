<%@ page import="java.util.List" %>
<%@ page import="Bitlab.SprintTask.Entity.Task1.model" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 16.06.2023
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

  <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
  + Добавить задание
  </button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="/add-task" method="post">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">
            Добавит Задания
          </h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <span>Наименование:</span>
          <input type="text" name="t_name" placeholder="Name"
                 style="width: 100%"><br>
          <span>Описание:</span>
          <input type="text" name="t_description" placeholder="description"
                 style="width: 100% "><br>
          <span>Крайний срок:</span>
          <input type="Date" name="t_deadlineDate" placeholder="deadlineDate" style="width: 100%"><br>
          <select type="hidden" name="t_status">
            <option type="hidden" selected>Нет</option>
            <option type="hidden">Да</option>
          </select>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыт</button>
          <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
      </form>
    </div>
  </div>
</div>


  <table class="table ">
    <thead>
    <tr>
      <th>ID</th>
      <th>Наименование</th>
      <th>Крайний срок</th>
      <th>Выполнено</th>
      <th>Детали</th>
    </tr>
    </thead>
    <tbody>
      <%
        List<model> tasks =(List<model>)request.getAttribute("task");
        for(model t: tasks)
        {
      %>
      <tr>
        <td><%=t.getId()%>
        </td>
        <td><%=t.getName()%>
        </td>
        <td><%=t.getDeadlineDate()%>
        </td>
        <td><%=t.getStatus()%>
        </td>
        <td>
          <button type="button" class="btn btn-sm btn-info" data-bs-toggle="modal"
                  data-bs-target="#updateModal<%= t.getId()%>">
            UPDATE
          </button>


          <div class="modal fade" id="updateModal<%=t.getId()%>" tabindex="-1"
               aria-labelledby="deleteModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <form action="details-task" method="post">
                  <div class="modal-header">
                    <h5 class="modal-title" id="updateModalLabel">
                      Info
                    </h5>
                    <button type="button" class="btn-close " data-bs-dismiss="modal"
                            aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <input type="hidden" name="id" value="<%=t.getId()%>">
                    <input type="text" name="t_name" placeholder="Name"
                           value="<%=t.getName()%>"><br>
                    <input type="text" name="t_description" placeholder="Name"
                           value="<%=t.getDescription()%>"><br>
                    <input type="date" name="t_deadlineDate" placeholder="deadLineDate"
                           value="<%=t.getDeadlineDate()%>"><br>
                    <select name="t_status">
                      <% String selected = "selected";%>
                      <option name="YES"> ДА
                      </option>
                      <option name="NO">
                        НЕТ
                      </option>
                    </select>
                  </div>
                  <div class="modal-footer">
                    <button  type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal"
                             data-bs-target="#deleteModal<%=t.getId()%>">
                      DELETE
                    </button>
                    <button type="submit" class="btn">SAVE</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="modal fade" id="deleteModal<%=t.getId()%>" tabindex="-1"
               aria-labelledby="deleteModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <form action="delete-task" method="post">
                  <div class="modal-header">
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <input type="hidden" name="id" value="<%=t.getId()%>">
                    <h2>ARE YOU SURE?</h2>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                    </button>
                    <button type="submit" class="btn btn-danger">DELETE</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </td>
      </tr>
      <%
        }
      %>
    </tbody>
  </table>
</body>
</html>
