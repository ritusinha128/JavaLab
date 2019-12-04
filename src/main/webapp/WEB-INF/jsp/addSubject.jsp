<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<jsp:include page="menu_subject.jsp" />
<body>
	<h3 style="color: red;">Add New Employee</h3>

	<div id="addEmployee">
		<form:form action="/addNewSubject" method="post" modelAttribute="stud">
			<p>
				<label>Enter code</label>
				<form:input path="code" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="sub_name" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="sub_sem" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="credits" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
</body>
</html>
