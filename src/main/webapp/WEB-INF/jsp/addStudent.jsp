<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/addNewStudent" method="post"
			modelAttribute="stud">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="USN" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Name" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Category" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="City" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Branch" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Sem" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Gender" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="dob" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
