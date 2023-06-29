<%@ page import="java.util.ArrayList" %>
<%@ page import="Bitlab.SprintTask.servlets.task1.SprintTask1" %>
<%@ page import="Bitlab.SprintTask.Entity.Task1.SprintTask1Task" %>
<%

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TASK MANAGER</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <style>
    .navbar{
        background-color: dodgerblue;
    }
    .btn{
        margin: 10px 10px;
    }
<%  String directory; %>
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg  >
        <div class="container-fluid">
            <a class="navbar-brand" href="#">TASK MANAGER</a>
            <a class="navbar-brand" href="#">Все задания</a>
        </div>
    </nav>
    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
        + Добавить задание
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="add-task" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">
                            Info
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
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыт</button>
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Наименование</th>
            <th scope="col">Крайний срок</th>
            <th scope="col">Выполнено</th>
            <th scope="col">Детали</th>
        </tr>
        </thead>
        <tbody>
                <% ArrayList<SprintTask1Task> frontTasks =
                    (ArrayList<SprintTask1Task>) request.getAttribute("Task");
                %>
                <% for (SprintTask1Task t: frontTasks){%>

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
                                <form action="save-task" method="post">
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
                                        <button type="submit" class="btn btn-danger">SAVE</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Modal -->
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
        </tbody>
            <%
            }
            %>
    </table>
</html>


