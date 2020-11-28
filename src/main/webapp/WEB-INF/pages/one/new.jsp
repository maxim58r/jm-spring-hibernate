<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<body>

<form th:method="POST" th:action="@{/new}" th:object="${user}">
    <input type="hidden" name="_method" value="POST">
    <br>
   <label for="username">Enter username: </label>
    <input type="text" th:field="*{username}" id="username">
    <div style="color: red" th:if="${#fields.hasErrors('username')}" th:errors="*{username}">Name error</div>
    <br>
   <label for="password">Enter password: </label>
    <input type="text" th:field="*{password}" id="password">
    <div style="color: red" th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Password error</div>
    <br>
    <input type="submit" value="Create user">
</form>

</div>
</body>
</html>