<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

<h3>Info about all users</h3>
<br/><br/>
<security:authorize access="hasRole('USER')">
    <input type="button" value="For users"
           onclick="window.location.href='/user/users'">
</security:authorize>

<br/><br/>

<security:authorize access="hasRole('ADMIN')">
<input type="button" value="For admins"
       onclick="window.location.href='/admin/1'">
</security:authorize>
<hr/>

</body>
</html>