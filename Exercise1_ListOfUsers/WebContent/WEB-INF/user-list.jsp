<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: darkblue">
	<div>
		<a href="" class="navbar-brand"> User Management App </a>
	</div>

	<ul class="navbar-nav nav-tabs">
		<li><a href="list"
			class="nav-link">Users</a></li>
	</ul>
	</nav> </header>
	<br />

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr />
			<div class="container text-left">
				<a href="new"
					class="btn btn-outline-dark">Add New User</a>
			</div>
			<br />
			<table class="table table-bordered table-striped">
				<thead class="table-dark">
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Email</td>
						<td>Country</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUsers}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.name}</td>
							<td>${user.email }</td>
							<td>${user.country }</td>
							<td><a
								href="edit?id=${user.id}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=${user.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>