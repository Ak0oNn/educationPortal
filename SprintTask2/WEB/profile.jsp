<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 23.06.2023
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bitlab shop</title>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<%
 User user = (User) request.getSession().getAttribute("CURRENT_USER");
 if(user != null){
%>
<div class="container" style="min-height: 500px;">
    <div class="row mt-3">
        <div class="col-12">
            <h3 class="text-center">PROFILE PAGE OF <%=user.getFullName()%>  </h3>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
