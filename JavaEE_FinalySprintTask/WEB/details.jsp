<%@ page import="Model.Post" %>
<%@ page import="Model.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 07.07.2023
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Detail</title>
  <%@include file="head.jsp"%>
  <%@include file="navbar.jsp"%>
  <%
    User user = (User) request.getSession().getAttribute("CURRENT_USER");
  %>
</head>
<body>
<%
  if(user.getRole().equals("1")){
%>
<div class="container">
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <%
        Post post = (Post) request.getAttribute("new");
        if (post != null) {
      %>
      <h5 class="card-title"><%=post.getTitle()%></h5>
      <h6 class="card-subtitle mb-2 text-body-secondary"><%=post.getCategory().getName()%></h6>
      <p class="card-text"><%=post.getContent()%></p>
      <h6 class="card-subtitle mb-2 text-body-secondary"><%=post.getPostDate()%>></h6>
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editPostModal">
        Edit Post
      </button>
      <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
        Delete Post
      </button>

      <!-- Modal -->
      <form action="/delete-post" method="post">
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <input type="hidden" name="id" value="<%=post.getId()%>">
                <h1>ARE U SURE?</h1>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-danger">YES</button>
              </div>
            </div>
          </div>
        </div>
      </form>

      <form action="/edit-post" method="post">
        <div class="modal fade" id="editPostModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="examplePostLabel">Edit Profile</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <input type="hidden" name="id" value="<%=post.getId()%>">
                <div class="mb-3">
                  <label class="form-label">Title</label>
                  <input class="form-control" type="text" name="title" value="<%=post.getTitle()%>">
                </div>
                <div class="mb-3">
                  <label class="form-label">Content</label>
                  <input class="form-control" type="text" name="content" value="<%=post.getContent()%>">
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
        List<Comment> comments = (List<Comment>) request.getAttribute("comments");
        for (Comment c : comments) {
      %>
      <h5><%=c.getUser().getFullName()%>
      </h5>
      <p><%=c.getComment()%>
      </p>
      <%
        var resultHours = ChronoUnit.HOURS.between(c.getPost_date(), LocalDateTime.now());
        var resultDays = ChronoUnit.DAYS.between(c.getPost_date(), LocalDateTime.now());
        if (resultHours > 0 && resultHours < 24) {
      %>
      <p>comment added at <%=resultHours%> hours ago</p>
      <%
      } else if (resultDays > 0 && resultDays < 30) {
      %>
      <p>comment added at <%=resultDays%> days ago</p>
      <%
          }
        }
      %>
      <%
        }
      %>

      <form action="/comment" method="post">
        <input type="hidden" name="post_id" value="<%=post.getId()%>">
        <textarea name="comment" class="form-control"
                  placeholder="Insert comment..."></textarea>
        <br>
        <button class="btn btn-primary">ADD COMMENT</button>
      </form>
    </div>
  </div>
</div>
<%
  }
%>
<%
  if(user.getRole().equals("2")){
%>
<div class="container">
  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <%
        Post post = (Post) request.getAttribute("new");
        if (post != null) {
      %>
      <h5 class="card-title"><%=post.getTitle()%></h5>
      <h6 class="card-subtitle mb-2 text-body-secondary"><%=post.getCategory().getName()%>></h6>
      <p class="card-text"><%=post.getContent()%></p>
      <h6 class="card-subtitle mb-2 text-body-secondary"><%=post.getPostDate()%>></h6>
      <%
        List<Comment> comments = (List<Comment>) request.getAttribute("comments");
        for (Comment c : comments) {
      %>
      <h5><%=c.getUser().getFullName()%>
      </h5>
      <p><%=c.getComment()%>
      </p>
      <%
        var resultHours = ChronoUnit.HOURS.between(c.getPost_date(), LocalDateTime.now());
        var resultDays = ChronoUnit.DAYS.between(c.getPost_date(), LocalDateTime.now());
        if (resultHours > 0 && resultHours < 24) {
      %>
      <p>comment added at <%=resultHours%> hours ago</p>
      <%
      } else if (resultDays > 0 && resultDays < 30) {
      %>
      <p>comment added at <%=resultDays%> days ago</p>
      <%
          }
        }
      %>
      <%
        }
      %>

      <form action="/comment" method="post">
        <input type="hidden" name="post_id" value="<%=post.getId()%>">
        <textarea name="comment" class="form-control"
                  placeholder="Insert comment..."></textarea>
        <br>
        <button class="btn btn-primary">ADD COMMENT</button>
      </form>
    </div>
  </div>
</div>
<%
  }
%>
</body>
</html>
