<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo=" crossorigin="anonymous"></script>
<title>Survey's - <%=request.getAttribute("Stitle")%></title>
<script type="text/javascript">$( document ).ready(function() {
	$('#anfang').hide();
	$('#Ende').hide();
});
</script>
</head>
<body>
	<h1>Survey's<small> <%=request.getAttribute("Stitle")%></small></h1>
	
	<% Survey survey = (Survey)request.getAttribute("survey"); %>
	
	<% if (test == true){ %>
	  <h1>It's true!</h1>
	<% } %>
	
	<% for(SurveyQuestion question : survey.getQuestions()){ %>
	  <%= question.getText() %> <input name="..." />
	<% } %> 
	
	<hr>
	<div class="container">
		<form method="POST">
			<div class="container">
			<seite id="Start" style="margin:0px">
			<div class="row">
			<div class="col-xs-6"></div>
  			<div class="col-xs-6"><button type="button" class="btn btn-success" style="float: right;" onclick="$('#Start').fadeOut(200);$('#anfang').fadeIn(200)">Fertig</button></div>
			</div>
			</seite>
		
			<seite id="anfang" style="margin:0px">
			<div class="form-group">

				<label for="Email">Deine Email-adresse:</label> <input type="email"
					class="form-control" id="Email" placeholder="Email" name="email">
			</div>
			<div class="form-group">
				<label for="TA">Deine Botschaft</label>
				<textarea class="form-control" rows="3" id="TA" name="M"></textarea>
			</div>
			bold funktioniert
			
			<div class="row">
  <div class="col-xs-6"><button type="button" class="btn btn-default" onclick="$('#anfang').hide(200);$('#Start').show(200)">zurück</button></div>
  <div class="col-xs-6"><button type="button" class="btn btn-success" style="float: right;" onclick="$('#anfang').hide(200);$('#Ende').show(200)">weiter</button></div></div>

			</seite>
			
			<seite id="Ende" style="display: none;">
			<div class="row">
			<div class="col-xs-6"><button type="button" class="btn btn-default" onclick="$('#Ende').hide(200);$('#anfang').show(200)">zurück</button></div>
  			<div class="col-xs-6"><button type="submit" class="btn btn-success" style="float: right;" onclick="$('#Ende').hide(200);$('#Start').show(200)">Fertig</button>
			</div></div>
			</seite>
		</div></form>
	</div>


</body>

</html>