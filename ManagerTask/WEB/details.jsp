<%@ page import="Bitlab.SprintTask.Entity.Task1.Task" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 18.06.2023
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<%
    Task task = (Task) request.getAttribute("task");
    if (task != null) {
%>
<div class="container">
    ID: <b><%=task.getId()%>
</b><br><br>
    NAME: <b><%=task.getName()%>
</b><br><br>
    DESCRIPTION: <b><%=task.getDescription()%>
</b><br><br>
    PRICE: <b><%=task.getDeadlineDate()%>
</b><br><br>
    STATUS: <b><%=task.getStatus()%>
</b><br><br>
    <div style="display: flex">
        <div style="margin-right: 10px;">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                Удалить задания
            </button>
            <!-- Modal -->
            <form action="/delete-task" method="post">
                <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" name="id" value="<%=task.getId()%>">
                                <h1>ВЫ ТОЧНО ХОТИТЕ УДАЛИТЬ?</h1>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">НЕТ</button>
                                <button type="submit" class="btn btn-danger">ДА</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editTaskModal">
                Изменить задания
            </button>

            <!-- Modal -->
            <form action="/edit-task" method="post">
            <div class="modal fade" id="editTaskModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" >Редактирования</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="t_id" value="<%=task.getId()%>">
                            <span>Наименование:</span>
                            <input value="<%=task.getName()%>" type="text" name="t_name" placeholder="Name"
                                   style="width: 100%"><br>
                            <span>Описание:</span>
                            <input value="<%=task.getDescription()%>" type="text" name="t_description" placeholder="description"
                                   style="width: 100% "><br>
                            <span>Крайний срок:</span>
                            <input value="<%=task.getDeadlineDate()%>" type="Date" name="t_deadlineDate" placeholder="deadlineDate"
                                   style="width: 100%"><br>
                            <span>Статус</span><br>
                            <select name="t_status">
                                <option value="<%=task.getStatus()%>">Нет</option>
                                <option value="<%=task.getStatus()%>">Да</option>
                            </select>
                        </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary">сохранить </button>
                        </div>
                    </div>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
<%
    }
%>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container" style="min-height: 500px;">
    <div class="row mt-3">
        <div class="col-6 mx-auto">
            <%
                String emailError = request.getParameter("emailerror");
                if(emailError!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect email, try again!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                String passwordError = request.getParameter("passworderror");
                if(passwordError!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect password, try again!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/login" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>EMAIL</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" class="form-control" required placeholder="Email" name="email">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>PASSWORD</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" required placeholder="Password" name="password">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">SIGN IN</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
<%@include file="foot.jsp"%>
</html>