<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books Management</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<header> <nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: #003b46;  ">
	<div>
		<a href="" class="navbar-brand" style="font-weight: bold;"> Books
			Management </a>
	</div>

	<ul class="navbar-nav nav-tabs">
		<li><a href="list"
			class="nav-link">Add New Book</a></li>
		<li><a href="list"
			class="nav-link">List All Books</a></li>
	</ul>
	</nav> </header>
	<div class="container-fluid"
		style="background-image: url('https://images.unsplash.com/photo-1507842217343-583bb7270b66?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1153&q=80'); height: 100vh; background-size: cover; background-position: center;";>
		<div class="container col-md-5" style="padding-top: 20px">
			<div class="card">
				<div class="card-body">
					<c:if test="${book == null}">
						<form action="insert"
							method="post">
							<caption>
								<h2>Add New Book</h2>
							</caption>
					</c:if>
					<c:if test="${book != null}">
						<form action="update"
							method="post">
							<caption>
								<h2>Edit Book</h2>
							</caption>
							<fieldset class="form-group">
								<label>ID</label> <input type="text"
									value='${book.book_id}' class="form-control"
									disabled="disabled">
							</fieldset>
					</c:if>
					<input type="hidden" value='${book.book_id}' class="form-control"
						name="book_id">
					<fieldset class="form-group">
						<label>Title</label> <input type="text" value='${book.title}'
							class="form-control" name="title" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Author</label> <input type="text" value='${book.author}'
							class="form-control" name="author">
					</fieldset>

					<fieldset class="form-group">
						<label>Price</label> <input type="text" value='${book.price}'
							class="form-control" name="price">
					</fieldset>
					<c:if test="${book == null }">
						<button type="submit" class="btn btn-success">Save</button>
					</c:if>
					<c:if test="${book != null }">
						<button type="submit" class="btn btn-success">Update</button>
					</c:if>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>