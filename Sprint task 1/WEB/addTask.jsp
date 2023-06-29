<%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 16.06.2023
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="navbarTask.jsp"%>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/add-task" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">
                        Новое Задания
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
                    <select type="hidden" name ="t_status">
                        <option selected >NO</option>
                        <option>YES</option>
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
</body>
</html>
