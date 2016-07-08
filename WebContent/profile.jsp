<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

	<h2>
		Your Profile for
		<c:out value="${user.username}" />
	</h2>

	<form action="ProfileServlet" method="post">
	<table class="table table-bordered table-hover width=50%">
		<thead>
			<tr>
				<th>Current</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td><c:out value="${user.useremail}" /></td>
				<td><input type="text" name="email" id="email" value=""></input></td>
			</tr>
			<tr>
				<td><c:out value="${user.motto}" /></td>
				<td><input type="text" name="motto" id="motto" value=""></input></td>
			</tr>
			<tr>
				<td><c:out value="${user.userpassword}" /></td>
				<td><input type="text" name="password" id="password" value=""></input></td>
			</tr>

		</tbody>
	</table>
	
	<input type="hidden" name="action" id="action" value="edit"></input>
	<input type="submit" name="submit" id="submit" value="Submit"></input>
	</form>
	
	
</body>
</html>