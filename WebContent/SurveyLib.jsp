<%@page import="java.util.List"%>
<%@page import="de.simonlaux.Survey.Survey"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-2.2.3.min.js"
	integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Survey's</title>
</head>
<body>
	<h1>Survey's</h1>
	<hr>
	<%
		if (request.getAttribute("sErr") != null) {
	%>
	<div class='alert alert-warning alert-dismissible' role='alert'>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span><span
			class='sr-only'>Error:</span>
		<%=request.getAttribute("sErr")%>
	</div>
	<%
		}
	%>
	<div class="container">
		<form method="GET">
			<div class="container">
				<div class="col-lg-6">
					<div class="input-group">
						<input name="id" type="text" class="form-control"
							placeholder="Get Survey by ID "> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</form>
		<hr>
		<div class="row">
		<% List<Survey> sugg =(List<Survey>)request.getAttribute("suggestedSurveys"); %>
		<% for(int i=0;i<sugg.size();i++) { %>
		
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
				<div class="caption">
						<h3><%=sugg.get(i).getName() %></h3>
						<p><%=sugg.get(i).getDescription() %></h3></p><!-- TODO Maximal länge-->
						<p>
							<a href="?id=<%=i %>" class="btn btn-primary" role="button">Teilnehmen</a><!-- TODO guter identfier fehlt -->
						</p>
					</div>
				</div></div>
				
		<% } %>
		</div>


	</div>


</body>

</html>