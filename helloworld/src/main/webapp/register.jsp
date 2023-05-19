<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>名前入力</title>
</head>
<body>
<h1>名前入力</h1>
<form action="saveUser" method="post">
<label for="name">名前:</label>

 <input type="text" id="name" name="userDTO.name" required>
<br>
<input type="submit" value="保存">
</form>

</body>
</html>
