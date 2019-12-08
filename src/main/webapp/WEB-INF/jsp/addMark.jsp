<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<!DOCTYPE html>
<html lang="en">
<head>
  <title>Student Details Portal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      background-color: #4c4cff;
      color: white;
      padding: 15px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-image: url("https://i.makeagif.com/media/12-21-2015/EgD1hy.gif");
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #4c4cff;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>



<nav class="navbar navbar-light" style="color:white">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" style="color:white" href="#">Student Details Portal</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a style="color:white" href="${pageContext.request.contextPath}/welcome">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>EMPTY</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <jsp:include page="menu.jsp" />
    </div>
    <div class="col-sm-8 text-left"> 
      <h1 style="color:#4c4cff">Student Details Portal<a style="margin-left: 30px;" href="${pageContext.request.contextPath}/getMarks" class="btn btn-success" role="button">View Marks</a>
      <a style="margin-left: 10px;" href="${pageContext.request.contextPath}/getMarksbyValue" class="btn btn-warning" role="button">Search for Mark</a>
      
      </h1>
      
      <div id="addEmployee">
		<form:form action="/addNewMark" method="post"
			modelAttribute="stud">
			<p>
				<label>Enter Student USN:</label>
				<form:input path="Student_USN" />
			</p>
			<p>
				<label>Enter Subject Code:</label>
				<form:input path="Sub_code" />
			</p>
			<p>
				<label>Enter Grade:</label>
				<form:input path="Grade" />
			</p>
			<p>
				<label>Enter Semester:</label>
				<form:input path="Sem" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
	</div>
      
      <hr>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Created by Ritu Sinha, Shruthi Raju, Yashita Shivraj</p>
</footer>

</body>
</html>






