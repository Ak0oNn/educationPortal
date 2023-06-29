<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BITLAB SHOP</title>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
    <style>
        .container {
            max-width: 960px;
        }
    </style>
</head>
<body>

<div class="container py-3">
    <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
        <%
            List<Item> items =(List<Item>)request.getAttribute("item");
            for (Item i : items) {
        %>
        <div class="col">
            <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                    <h4 class="my-0 fw-normal"><%=i.getName()%></h4>
                </div>
                <div class="card-body">
                    <h1 class="card-title pricing-card-title"><%="$"+i.getPrice()%><small class="text-body-secondary fw-light">/mo</small></h1>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><%=i.getDescription()%></li>
                    </ul>
                    <button type="button" class="w-100 btn btn-lg btn-outline-primary">Buy Now</button>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>


</body>
</html>
