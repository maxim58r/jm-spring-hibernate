<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

<h2>All Users</h2>
<br/><br/>
<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
        <th>Salary</th>
        <th>Enabled</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="user" items="${users}">

        <c:url var="updateButton" value="/admin/${user.id}/edit">
            <c:param name="userId" value="${user.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/admin/${user.id}">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>${user.salary}</td>
            <td>${user.enabled}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>

<br/><br/>
<security:authorize access="hasAnyRole('CLIENT')">
    <input type="button" value="All users"
           onclick="window.location.href='/user/users'">
</security:authorize>

<br/><br/>

<%--    <security:authorize access="hasRole('EMPLOYEE')">--%>
<security:authorize access="hasAnyRole('EMPLOYEE')">
    <input type="button" value="Add new user"
           onclick="window.location.href='/admin/new'">
</security:authorize>
<hr/>
</body>
</html>