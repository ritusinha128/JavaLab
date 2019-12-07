<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/getSGPAbyUSN" method="post" modelAttribute="attr">
			<p>
				<label>Enter Employee Id</label>
				<form:input path="attribute" />
			</p>
			<p>
				<label>Enter Name</label>
				<form:input path="value" />
			</p>
			<input type="SUBMIT" value="Submit" />
</form:form>
<h3>${sgpa}</h3>
</body>
</html>