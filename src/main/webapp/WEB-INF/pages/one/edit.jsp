<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
<form th:method="PATCH" th:action="@{/{id}(id=${user.getId()})}" th:object="${user}">
    <!--    <input type="hidden" name="_method" value="PATCH">-->

    <label for="username">Enter first name: </label>
    <input type="text" th:field="*{username}" id="username">
    <div style="color: red" th:if="${#fields.hasErrors('username')}" th:errors="*{username}">Name error</div>
    <br>
    <label for="password">Enter password: </label>
    <input type="text" th:field="*{password}" id="password">
    <div style="color: red" th:if="${#fields.hasErrors('password')}" th:errors="*{password}">Password error</div>
    <br>
    <input type="submit" value="Update user">
</form>
</body>
</html>