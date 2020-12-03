<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<body>
<h3>Hello</h3>
<br/>
<form:form action="/admin/new" modelAttribute="user">
    <form:hidden path="id"/>

    Username<form:input path="username"/>
    <form:errors path="username"/>
    <br><br>

    Password<form:input path="password"/>
    <form:errors path="password"/>
    <br><br>

    Role<form:select path="role">
    <form:options items="${user.roles}"/>
</form:select>
    <br><br>

    Salary<form:input path="salary"/>
    <form:errors path="salary"/>
    <br><br>

    Enabled<form:select path="enabled">
    <form:options items="${user.enableds}"/>
</form:select>
    <br><br>

    <input type="submit" value="Ok">
</form:form>
</body>
</html>