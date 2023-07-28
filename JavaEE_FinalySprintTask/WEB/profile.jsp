<%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 10.07.2023
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<%
    User user = (User) request.getSession().getAttribute("CURRENT_USER");
    if (user != null) {
%>
<div class="container d-flex justify-content-center ">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title"><%=user.getFullName()%></h5>
            <p><%=user.getEmail()%></p>
            <button class="btn btn-primary" type="button" data-bs-toggle="modal" data-bs-target="#eidtProfileModal">Edit</button>
        </div>
    </div>
</div>
<form action="/edit-profile" method="post">
<div class="modal fade" id="eidtProfileModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Edit Profile</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input class="form-control" type="text" name="fullName" value="<%=user.getFullName()%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email address</label>
                    <input class="form-control" type="email" name="email" value="<%=user.getEmail()%>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input class="form-control" type="password" name="password" value="<%=user.getPassword()%>">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="Submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</form>
<%
    }
%>
</body>
</html>
