<%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 16.06.2023
  Time: 13:42
  To change this template use File | Settings | File Templates.
nabv--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</body>
</html>
