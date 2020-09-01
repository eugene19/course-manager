<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Course list</title>
</head>
<body>
<h3>Course list</h3>
<form action="profile" method="post">
    <input type="hidden" name="command" value="profile"/>
    <input type="submit" value="Profile"/>
</form>
<form action="logout" method="post">
    <input type="hidden" name="command" value="log_out"/>
    <input type="submit" value="Log out"/>
</form>

<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Статус</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ob" items="${courseList}">
        <tr>
            <td><c:out value="${ob.topic}"/></td>
            <td><c:out value="${ob.description}"/></td>
            <td><c:out value="${ob.status}"/></td>
            <td>
                <form action="editCourse" method="POST">
                    <button type="submit" name="id_course" value="${ob.id}">
                        Edit
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${courseList.size() == 0}">
    <H3>Нет ни одной записи.</H3>
</c:if>
</body>
</html>
