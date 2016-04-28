<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
<title>Survey's - <%=request.getAttribute("Stitle")%></title>
</head>
<body>
	<h1>Survey's<small> <%=request.getAttribute("Stitle")%></small></h1>
	<hr>
	<div class="container">
		<div class="container">
			<h3>Danke, das du an der Umfrage <b><i><%=request.getAttribute("Stitle")%></i></b> teilgenommen hast. </h3>
			<div class="row">
			<div class="col-xs-6"></div>
  			<div class="col-xs-6"><a class="btn btn-success" style="float: right;" href="?<%=Math.random()%>">zurück zur Übersicht</a></div>
			</div>
		</div>
	</div>


</body>

</html>