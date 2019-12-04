<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu_marks.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/addNewMark" method="post"
			modelAttribute="stud">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="Student_USN" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Sub_code" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Grade" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="Sem" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
