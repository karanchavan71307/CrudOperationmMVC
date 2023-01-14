<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@include file="./base.jsp"%> 
</head>
<body>

	<div class="container mt-3">
		<div class="row">

			<div class="col-md-12">

				<table class="table table-striped table-dark">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">name</th>
							<th scope="col">email</th>
							<th scope="col">password</th>
							<th scope="col">actions</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${student}" var="s">
						<tr>
							<th scope="row">${s.id}</th>
							<td>${s.name}</td>
							<td>${s.email}</td>
							<td>${s.password}</td>
							<td><a href="/delete/${s.id}"><i class="fa fa-trash btn btn-danger" aria-hidden="true"></i></a>
							
							  <a href="update/${s.id}"><i class="fa fa-pencil btn btn-warning" aria-hidden="true" style="font-size: 35"></i></a>
							</td>
							</tr>
							</c:forEach>
					</tbody>										
					
				</table>
				
				
				<div class="container text-center">
				<a href="/getpage" class="btn btn-primary">Add Student</a>
				
				</div>
				


			</div>

		</div>

	</div>

</body>
</html>