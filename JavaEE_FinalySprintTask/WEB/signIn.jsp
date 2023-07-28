<%@ page import="Model.User" %><%--
  Created by IntelliJ IDEA.
  User: Ayan
  Date: 05.07.2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<%@include file="navbar.jsp"%>
<%
    String errEmail = request.getParameter("err-email");
    String success = request.getParameter("success");
%>
<%
    if (errEmail != null) {
%>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
    <strong>Email is busy!</strong>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%
    }
%>
<%
    if (success != null) {
%>
<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong>U are created new account!</strong>
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%
    }
%>
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
            <form action="/sign-user" method="post">
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
                        <button type="submit" class="btn btn-success">SIGN IN</button>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <H6>don't have account</H6>
                    </div>
                    <div class="col-12">
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#signupModal">
                            SIGN UP
                        </button>

                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- Modal -->
    <form action="/sign-up" method="post">
        <div class="modal fade" id="signupModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">SIGN UP.</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Email address</label>
                            <input  name="email" type="email" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="validationPassword" class="form-label">Password</label>
                            <div class="input-group has-validation">
                                <input name="password" onkeyup="passValidation()" type="password" class="form-control"
                                       id="validationPassword" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                                <script type="text/javascript">
                                    function passValidation() {
                                        var value = document.getElementById('validationPassword').value
                                        if (value.length < 6) {
                                            document.getElementById('validationPasswordFeedback').style = "display: block"
                                        } else {
                                            document.getElementById('validationPasswordFeedback').style = "display: none"
                                        }
                                    }
                                </script>
                                <div style="display: none" id="validationPasswordFeedback" class="invalid-feedback">
                                    min 6 symbols.
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="validationRePassword" class="form-label">Retype Password</label>
                            <div class="input-group has-validation">
                                <input name="re_password" onkeyup="rePassValidation()" type="password" class="form-control"
                                       id="validationRePassword" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                                <script type="text/javascript">
                                    function rePassValidation() {
                                        var value = document.getElementById('validationRePassword').value
                                        if (value !== document.getElementById('validationPassword').value) {
                                            document.getElementById('validationRePasswordFeedback').style = "display: block"
                                        } else {
                                            document.getElementById('validationRePasswordFeedback').style = "display: none"
                                        }
                                    }
                                </script>
                                <div style="display: none" id="validationRePasswordFeedback" class="invalid-feedback">
                                    Password are not same!.
                                </div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Full name</label>
                            <input  name="full_name" type="text" class="form-control">
                        </div>
                        <input type="hidden" value="2" name="role">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">CREATE ACCOUNT</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
