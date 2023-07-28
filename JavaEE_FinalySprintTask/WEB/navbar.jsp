<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Ayan--%>
<%--  Date: 05.07.2023--%>
<%--  Time: 17:50--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <%@include file="head.jsp"%>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@ page import="Model.User" %>--%>
<%--<%--%>
<%--    User currentUser = (User) session.getAttribute("CURRENT_USER");--%>
<%--    if (currentUser!=null){--%>
<%--%>--%>
<%--<div class="container py-3">--%>
<%--    <header>--%>
<%--        <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">--%>
<%--            <a href="/" class="d-flex align-items-center link-body-emphasis text-decoration-none">--%>
<%--                <span class="fs-4">BITLAB NEWS</span>--%>
<%--            </a>--%>

<%--            <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">--%>
<%--                <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">World</a>--%>
<%--                <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Politics</a>--%>
<%--                <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Sports</a>--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"--%>
<%--                       data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        <%=currentUser.getFullName()%>--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <li><a class="dropdown-item" href="/profile">Profile</a></li>--%>
<%--                        <li><hr class="dropdown-divider"></li>--%>
<%--                        <li><a class="dropdown-item" href="/logout">Logout</a></li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </header>--%>
<%--</div>--%>
<%--<%--%>
<%--    }else {--%>
<%--%>--%>
<%--<div class="container py-3">--%>
<%--    <header>--%>
<%--        <div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">--%>
<%--            <a href="/" class="d-flex align-items-center link-body-emphasis text-decoration-none">--%>
<%--                <span class="fs-4">BITLAB NEWS</span>--%>
<%--            </a>--%>

<%--            <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">--%>
<%--                <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="signIn.jsp">Sign In</a>--%>
<%--                <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Sign Up</a>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </header>--%>
<%--</div>--%>
<%--<%--%>
<%--%>--%>
<%--</body>--%>
<%--</html>--%>

<%@include file="head.jsp"%>
<%@page import="Model.User" %>
<%
    User currentUser = (User) session.getAttribute("CURRENT_USER");
%>

    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgba(35,67,105,0.85);">
        <div class="container-fluid">
            <a class="navbar-brand" href="/home">BITLAB BLOG</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <%
                        if(currentUser!=null && currentUser.getRole().equals("1")){
                    %>
                    <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">World</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Politics</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Sports</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="/profile">Profile</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="/addPost">ADD NEW POST</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="/logout">Logout</a>
                    </nav>
                    <%
                    }else if (currentUser==null){
                    %>
                    <li class="nav-item">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <%
                        }else if (currentUser !=null && currentUser.getRole().equals("2")){
                    %>
                    <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">World</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Politics</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="#">Sports</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="/profile">Profile</a>
                        <a class="me-3 py-2 link-body-emphasis text-decoration-none" href="/logout">Logout</a>
                    </nav>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </nav>
