<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>

<p th:text="${user.getId()}">User id</p>
<p th:text="${user.getUsername()}">User</p>
<p th:text="${user.getPassword()}">User</p>
<!--<p th:text="${user.getRole()}">User</p>-->
<br/>
<hr/>
<a th:href="@{/{id}/edit(id=${user.getId()})}">Edit</a>
<a href="/users">All users</a>
<a href="/new">Add user</a>


<form th:method="DELETE" th:action="@{{id}(id=${user.getId()})}">
    <input type="submit" value="Delete"/>
</form>
</body>
</html>