<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, World!</title>
</head>
<body>
	こんにちは、<c:out value="${userName}" /> さん！

	<c:if test="${userName == 'Guest'}">
		<form method="post" action="./Hello">
			名前を入力してください: <input type="text" name="name">
			<button type="submit">送信</button>
		</form>
	</c:if>
</body>
</html>