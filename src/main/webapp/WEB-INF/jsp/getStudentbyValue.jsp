<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/getStudentbyValues" method="post" modelAttribute="attr">
			<p>
				<label>Enter attribute</label>
				<form:input path="attribute" />
			</p>
			<p>
				<label>Enter value</label>
				<form:input path="value" />
			</p>
			<input type="SUBMIT" value="Submit" />
</form:form>			
</body>
</html>