<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h2>Welcome ${user.username}</h2>
<br>
<br>
Your id: ${user.id}
<br><br>
Your username: ${user.username}
<br><br>
Your password: ${user.password}
<br><br>
Your enabled: ${user.role}
<br><br>
<input type="button" value="Update"
       onclick="window.location.href='/user/users'">
</body>
</html>