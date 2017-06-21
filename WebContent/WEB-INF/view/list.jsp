<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="todo.util.ConvertHelper" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List | Todo</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>内容</th>
				<th>期限</th>
				<th>完了</th>
				<th>更新</th>
				<th>削除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="todo">
				<tr>
					<td><c:out value="${todo.id}" /></td>
					<td><pre><c:out value="${todo.task}" /></pre></td>
					<td><c:out value="${ConvertHelper.formatDate(todo.limit)}" /></td>
					<td><c:out value="${todo.done}" /></td>
					<td><a href="Edit?action=update&id=<c:out value="${todo.id}" />">更新</a></td>
					<td><a href="Edit?action=delete&id=<c:out value="${todo.id}" />">削除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="Edit?action=create">追加</a>
</body>
</html>