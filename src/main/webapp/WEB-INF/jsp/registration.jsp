<%@ page import="by.epamtc.courses.entity.UserType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration form</h2>

<div style="background-color: red; width: fit-content">
    ${error}
</div>

<form action="register" method="post">
    <input type="hidden" name="command" value="registration"/>

    Login<br/>
    <input type="text" name="login"/><br/>
    Password<br/>
    <input type="password" name="password"/> <br/>
    Name<br/>
    <input type="text" name="name"/> <br/>
    Surname<br/>
    <input type="text" name="surname"/> <br/>
    Register as<br/>
    <select name="type">
        <c:forEach var="type" items="<%=UserType.values()%>">
            <%--Заменить ординал на id в базе данных--%>
            <option
                    <c:if test="${type.id == 1}">selected</c:if>
                    value="${type.id}">
                    ${type.text}
            </option>
        </c:forEach>
    </select>

    <input type="submit" value="Register">
</form>
<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
