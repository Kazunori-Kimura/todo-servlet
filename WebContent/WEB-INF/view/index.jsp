<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, World!</title>
</head>
<body>
	<%= request.getAttribute("foo") %>

	<form method="post" action="./Hello">
		何か入力して: <input type="text" name="hoge">
		<button type="submit">送信</button>
	</form>
</body>
</html>