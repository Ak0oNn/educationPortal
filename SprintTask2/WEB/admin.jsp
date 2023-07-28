<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Brand" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 29.06.2023
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <%@include file="head.jsp"%>
    <%@include file="navbar.jsp"%>
</head>
<body>
<div class="container">
    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
        <h1 class="display-4 fw-normal text-body-emphasis">Admin Panel</h1>
    </div>
    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
        + ADD NEW
    </button>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/add-item" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">
                            Add New Product
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <span>Name:</span>
                        <input type="text" name="i_name" placeholder="Insert Name"
                               style="width: 100%"><br>
                        <span>Brand:</span>
                        <select name="brand_id" class="form-select">
                            <%
                                List<Brand> brands = (List<Brand>) request.getAttribute("brands");
                                for (Brand b : brands){
                            %>
                            <option value="<%=b.getId()%>"><%=b.getName()+"/"+b.getCountry()%></option>
                            <%
                                }
                            %>
                        </select>
                        <span>Price:</span>
                        <input type="number" name="i_price" placeholder="insert price"
                               style="width: 100%"><br>
                        <span>Description:</span>
                        <input type="text" name="i_description" placeholder="Insert description"
                               style="width: 100% "><br>
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
            <th>Name</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Description</th>
            <th>Details</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Item> items =(List<Item>)request.getAttribute("items");
            for (Item i : items) {
        %>
        <tr>
            <td><%=i.getId()%>
            </td>
            <td><%=i.getName()%>
            </td>
            <td><%=i.getBrand().getName()+"-"+i.getBrand().getCountry()%>
            </td>
            <td><%=i.getPrice()%>
            </td>
            <td><%=i.getDescription()%>
            </td>
            <td><a class="btn btn-dark" href="/details-task?id=<%=i.getId()%>">Детали</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
