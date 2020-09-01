<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
Login:
${user.login}<br/>
Name:
${user.name}<br/>
Surname:
${user.surname}<br/>
Type:
${user.type}<br/>

<c:if test="${user.type eq 'STUDENT'}">
    Подписаться на курсы<br/>
</c:if>

<c:if test="${user.type eq 'LECTURE'}">
    Создать курс<br/>
</c:if>


<a href="${pageContext.request.contextPath}/">Back</a>
</body>
</html>
