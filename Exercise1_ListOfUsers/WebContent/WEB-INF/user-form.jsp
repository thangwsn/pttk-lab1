<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Managament App</title>
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

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user == null}">
					<form action="insert"
						method="post">
						<caption>
							<h2>Add New User</h2>
						</caption>
				</c:if>
				<c:if test="${user != null}">
					<form action="update"
						method="post">
						<caption>
							<h2>Edit User</h2>
						</caption>
						<fieldset class="form-group">
							<label>ID User</label> <input type="text" value='${user.id}'
								class="form-control" disabled="disabled">
						</fieldset>
				</c:if>
				<input type="hidden" value='${user.id}' class="form-control" name="id">
				<fieldset class="form-group">
					<label>User Name</label> <input type="text" value='${user.name}'
						class="form-control" name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text" value='${user.email}'
						class="form-control" name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text"
						value='${user.country}' class="form-control" name="country">
				</fieldset>
				<c:if test="${user == null }">
					<button type="submit" class="btn btn-success">Save</button>
				</c:if>
				<c:if test="${user != null }">
					<button type="submit" class="btn btn-success">Update</button>
				</c:if>

				</form>
			</div>
		</div>
	</div>
</body>
</html>