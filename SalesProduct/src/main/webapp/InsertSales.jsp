<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
HttpSession ses = request.getSession(false);
if (ses == null || ses.getAttribute("uname") == null || ses.getAttribute("pass") == null) {
	response.sendRedirect("Login.jsp");
	return;
}
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


					</ul>
				</div>
			</div>
		</nav>

	</header>
	<main>

		<div class="container ">
			<div class="row justify-content-center align-items-center g-2 ">
				<div class="col-md-6 mt-5 p-3"
					style="box-shadow: 0px 0px 7px black;">
					<center>
						<h3>Add Details</h3>
						<hr>
					</center>
					<form action="InsertSaleController" method="post" onsubmit="return valid()">
					
					<div class="mb-3 mt-4">
				 <input type="hidden" class="form-control" name="id" id=""
								aria-describedby="helpId" placeholder="" />
						</div>
						<div class="mb-3 mt-4">
							<label for="" class="form-label">Sales Person name</label> <input
								type="text" class="form-control" name="sname" id=""
								aria-describedby="helpId" placeholder="" />
						</div>
						<div class="mb-3 mt-4">
							<label for="" class="form-label">Target</label> <input
								type="Number" class="form-control" name="target" id=""
								aria-describedby="helpId" placeholder="" />
						</div>
						<div class="mb-3 mt-4">
							<label for="" class="form-label">No of Units sold</label> <input
								type="Number" class="form-control" name="units" id=""
								aria-describedby="helpId" placeholder="" />
						</div>
						<div class="mb-3 mt-4">
							<label for="" class="form-label">status</label> <select
								class="form-control" name="status" id="selectStatus">
								<option value="" disabled selected>----Select---</option>
								<option value="Completed">Completed</option>
								<option value="Not Completed">Not Completed</option>
							</select>
						</div>

						<div class="mb-3 mt-4">
							<input type="hidden" name="addedby" value="" />
						</div>

						<center>
							<button type="submit" class="btn btn-primary ps-5 mt-3 pe-5">
								Submit</button>
						</center>

					</form>
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

	<Script>
		function valid() {
			let ss = document.getElementById("selectStatus");

			if (ss.value === "") {
				alert("Please select status before submitting form.");
				return false;
			}
			return true;
		}
	</Script>
</body>

</html>