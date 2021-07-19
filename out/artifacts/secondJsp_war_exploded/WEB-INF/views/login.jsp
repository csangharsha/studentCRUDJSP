<%@include file="../includes/header.jsp"%>
<h1>Login</h1>
<hr/>

<c:if test="${param.error != null}">
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        Invalid Credentials
    </div>
</c:if>

<c:if test="${param.auth_error != null}">
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        You are not authorized.
    </div>
</c:if>

<form method="post" action="${SITE_URL}/login">
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
</form>

<%@include file="../includes/footer.jsp"%>
