<%@ page import="java.util.List" %>
<%@ page import="Model.Post" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 07.07.2023
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bitlab News</title>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
    <%@page import="Model.User" %>
    <%
        User user = (User) request.getSession().getAttribute("CURRENT_USER");
    %>
</head>
<body>
<%
    if(user.getRole().equals("1")){
%>
<div class="container py-3">
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
        <%
            List<Post> posts = (List<Post>)request.getAttribute("posts");
            for (Post p :posts){
        %>
        <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                    <h4 class="my-0 fw-normal"><%=p.getTitle()%></h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title"><%=p.getContent()%></h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><%=p.getCategory().getName()%></li>
                        <li><%=p.getPostDate()%></li>

                    </ul>
                    <a href="/details-post?id=<%=p.getId()%>"
                            class="w-100 btn btn-lg btn-outline-primary">
                        Read more
                    </a>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%
    }
%>

<%
    if(user.getRole().equals("2")){
%>
<div class="container py-3">
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
        <%
            List<Post> posts = (List<Post>)request.getAttribute("posts");
            for (Post p :posts){
        %>
        <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                    <h4 class="my-0 fw-normal"><%=p.getTitle()%></h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title"><%=p.getContent()%></h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><%=p.getCategory().getName()%></li>
                        <li><%=p.getPostDate()%></li>
                    </ul>
                    <a
                            href="/details-post?id=<%=p.getId()%>"
                            class="w-100 btn btn-lg btn-outline-primary">
                        Read more
                    </a>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<%
    }
%>
</body>
</html>
