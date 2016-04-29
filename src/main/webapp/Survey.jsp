<%@page import="de.simonlaux.survey.SurveyQuestion"%>
<%@page import="de.simonlaux.survey.Survey"%>
<html>
<head>
<%
	Survey survey = (Survey) request.getAttribute("Survey");
%>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"
	integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Survey's - <%=survey.getName()%></title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#Umfrage').fadeIn(1000);
	});
</script>
</head>
<body>
	<h1>
		Survey's<small> <%=survey.getName()%></small>
	</h1>


	<hr>
	<div class="container">

		<seite id="Umfrage" style="display:none">
		<div class="media">
			<div class="media-left" style="allign: center;">
				<div class="media-object"
					style="text-align: center; width: 64px; height: 64px; font-size: 45px; border: 2px solid #73AD21; background: #ecf0f1;padding 5px;">
					<b><%=survey.getQuestionCount()%></b>
				</div>

				<!-- <img class="media-object" src="..." alt=""> -->
			</div>
			<div class="media-body">
				<h4 class="media-heading"><%=survey.getName()%></h4>
				<%=survey.getDescription()%>
			</div>
		</div>
		<br>

		<form method="POST" onsubmit="$('#Umfrage').fadeOut(2000);">
			<div class="container">
				<%
					for (SurveyQuestion question : survey.getQuestions()) {
						if (question.getTyp() == "String") {
				%>

				<div class="form-group">
					<label for="ST<%=question.getID()%>"><%=question.getFrage()%></label> <input
						type="text" class="form-control" id="ST<%=question.getID()%>"
						placeholder="<%=question.getFrage()%>" required name="Antwort<%=question.getID()%>">
				</div>

				<%
					} else {
				%>
				<%=question.getFrage()%><input />
				<%
					}
				%>
				<br>
				<%
					}
				%>

				<div class="row">
					<div class="col-xs-6"></div>
					<div class="col-xs-6">
						<button type="submit" class="btn btn-success"
							style="float: right;">Fertig</button>
					</div>
				</div>
		</seite>

	</div>
	</form>
	</div>


</body>

</html>