<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="todo.util.ConvertHelper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit | Todo</title>
</head>
<body>
	<h1>
		<c:choose>
			<c:when test="${action == 'create'}">作成</c:when>
			<c:when test="${action == 'update'}">更新</c:when>
			<c:when test="${action == 'delete'}">削除</c:when>
		</c:choose>
	</h1>

	<form action="Edit" method="post">
		<input type="hidden" name="action" value="<c:out value="${action}" />">
		<div>
			<label for="id">ID</label>
			<input type="text" name="id" value="<c:out value="${todo.id}" />" readonly>
		</div>
		<div>
			<label for="task">内容</label>
			<textarea name="task"><c:out value="${todo.task}" /></textarea>
		</div>
		<div>
			<label for="limit">期限</label>
			<input type="date" name="limit" value="<c:out value="${ConvertHelper.formatDate(todo.limit)}" />">
		</div>
		<div>
			<label><input type="checkbox" name="done"
				<c:if test="${todo.done}">checked</c:if>> 完了</label>
		</div>

		<button type="submit">OK</button>
		<a href="./List">Cancel</a>
	</form>
</body>
</html>