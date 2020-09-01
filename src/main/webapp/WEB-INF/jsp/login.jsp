<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login form</h2>

<div style="background-color: red; width: fit-content">
    ${error}
</div>

<form action="login" method="post">
    <input type="hidden" name="command" value="login"/>

    Login<br/>
    <input type="text" placeholder="login" name="login"/><br/>

    Password<br/>
    <input type="password" placeholder="password" name="password"/> <br/>


    <input type="submit" value="Login">
</form>
<a href="${pageContext.request.contextPath}/register">Registration</a>
</body>
</html>
