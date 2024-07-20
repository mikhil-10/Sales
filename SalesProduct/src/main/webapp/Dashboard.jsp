<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<%
HttpSession ses = request.getSession(false);
if (ses == null || ses.getAttribute("uname") == null || ses.getAttribute("pass") == null) {
	response.sendRedirect("Login.jsp");
	return;
}

String dbname = "jdbc:mysql://localhost:3306/task";
String dbuname = "root";
String dbpass = "";

try {
	Connection con = DriverManager.getConnection(dbname, dbuname, dbpass);

	String query = "Select * from products";

	Statement ss = con.createStatement();

	ResultSet rs = ss.executeQuery(query);
%>

<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS v5.2.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
</head>

<body>
	<header>
		<!-- place navbar here -->
		<nav class="navbar navbar-expand-sm navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="#">Navbar</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav me-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link active"
							href="index.jsp" aria-current="page">Home <span
								class="visually-hidden">(current)</span></a></li>
						<li class="nav-item"><a class="nav-link active"
							href="Dashboard.jsp" aria-current="page">Dashboard <span
								class="visually-hidden">(current)</span></a></li>
						<li class="nav-item"><a class="nav-link active"
							href="InsertSales.jsp" aria-current="page">Insert Sales <span
								class="visually-hidden">(current)</span></a></li>
								
								<li class="nav-item"><a class="nav-link active"
							href="Logout" aria-current="page">Logout <span
								class="visually-hidden">(current)</span></a></li>


					</ul>
				</div>
			</div>
		</nav>

	</header>
	<main>

		<div class="container ">
			<div class="row justify-content-center align-items-center g-2 ">
				<div class="col mt-5 p-3" style="box-shadow: 0px 0px 7px black;">
					<center>
						<h3>Dashboard</h3>
						<h4>
							Welcome
							<%=ses.getAttribute("uname")%></h4>
					</center>
				</div>

				<div class="table-responsive">
					<table class="table ">
						<thead>
							<tr>
								<th scope="col">Salespersonname</th>
								<th scope="col">Target</th>
								<th scope="col">No of units sold</th>
								<th scope="col">Status</th>
								<th scope="col">Added by</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<%
							while (rs.next()) {
							%>
							<tr class="">
								<td scope="row"><%=rs.getString("salespersonname")%></td>
								<td><%=rs.getString("target")%></td>
								<td><%=rs.getString("unitSold")%></td>
								<td><%=rs.getString("status")%></td>
								<td><%=rs.getString("addedby")%></td>
								<td>
									<a name="" id="" class="btn border border-dark p-1 ms-2" href="updateDashboard.jsp?id=<%=rs.getString("id")%>" role="button">Update</a>
									<a name="" id="" class="btn border border-dark p-1 ms-2" href="DeleteController?id=<%=rs.getString("id")%>" role="button">Delete</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>


			</div>

		</div>

		</div>

	</main>

	<!-- Bootstrap JavaScript Libraries -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>

</body>

</html>