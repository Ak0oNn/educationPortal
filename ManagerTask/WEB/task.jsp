<%@ page import="java.util.List" %>
<%@ page import="Bitlab.SprintTask.Entity.Task1.Task" %><%--
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
    <%@include file="head.jsp" %>

    <style>
        .btn {
            margin: 10px 10px;
        }
    </style>

</head>
<body>
<%@include file="navbar.jsp" %>


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
        List<Task> tasks = (List<Task>) request.getAttribute("task");
        for (Task t : tasks) {
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
        <td><a class="btn btn-dark" href="/details-task?id=<%=t.getId()%>">Детали</a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
