package de.simonlaux.survey;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowSurvey
 */
@WebServlet(description = "Zeigt die Umfragen an", urlPatterns = { "/ShowSurvey" })
public class ShowSurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SurveyStore store;

	public void init(ServletConfig config) throws ServletException {
		store = InMemorySurveyStore.getInstance();
		System.out.println(store.add(new Survey("Test",
				Arrays.asList(new SurveyQuestion("How old are you?", "age", SurveyQuestion.TYPE_STRING),
						new SurveyQuestion("Seite2", "d", SurveyQuestion.TYPE_STRING),
						new SurveyQuestion("frage", "name", SurveyQuestion.TYPE_STRING)),
				"eine Test-Umfrage")));
		System.out
				.println(store.add(new Survey("Lorem Ipsum",
						Arrays.asList(new SurveyQuestion(
								"How old are you?", "age", SurveyQuestion.TYPE_STRING),
								new SurveyQuestion("Seite2", "d", SurveyQuestion.TYPE_STRING),
								new SurveyQuestion("frage", "name", SurveyQuestion.TYPE_STRING)),
						"Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")));
		System.out.println(store.add(new Survey("Lorem Ipsum German",
				Arrays.asList(new SurveyQuestion("Frage 1", "d", SurveyQuestion.TYPE_STRING),
						new SurveyQuestion("Frage?", "name", SurveyQuestion.TYPE_STRING)),
				"Auch gibt es niemanden, der den Schmerz an sich liebt, sucht oder wünscht, nur, weil er Schmerz ist, es sei denn, es kommt zu zufälligen Umständen, in denen Mühen und Schmerz ihm große Freude bereiten können. Um ein triviales Beispiel zu nehmen, wer von uns unterzieht sich je anstrengender körperlicher Betätigung, außer um Vorteile daraus zu ziehen? Aber wer hat irgend ein Recht, einen Menschen zu tadeln, der die Entscheidung trifft, eine Freude zu genießen, die keine unangenehmen Folgen hat, oder einen, der Schmerz vermeidet, welcher keine daraus resultierende Freude nach sich zieht? Auch gibt es niemanden, der den Schmerz an sich liebt, sucht oder wünscht, nur, weil er Schmerz ist, es sei denn, es kommt zu zufälligen Umständen, in denen Mühen und Schmerz ihm große Freude bereiten können. Um ein triviales Beispiel zu nehmen, wer von uns unterzieht sich je anstrengender körperlicher Betätigung, außer um Vorteile daraus zu ziehen? Aber wer hat irgend ein Recht, einen Menschen zu tadeln, der die Entscheidung trifft, eine Freude zu genießen, die keine unangenehmen Folgen hat, oder einen, der Schmerz vermeidet, welcher keine daraus resultierende Freude nach sich zieht?Auch gibt es niemanden, der den Schmerz an sich liebt, sucht oder wünscht, nur, ")));
		System.out.println(store.add(new Survey("Hinter den Wortbergen ",
				Arrays.asList(new SurveyQuestion("Frage 1", "d", SurveyQuestion.TYPE_STRING),
						new SurveyQuestion("Frage?", "name", SurveyQuestion.TYPE_STRING)),
				"Weit hinten, hinter den Wortbergen, fern der Länder Vokalien und Konsonantien leben die Blindtexte. Abgeschieden wohnen sie in Buchstabhausen an der Küste des Semantik, eines großen Sprachozeans. Ein kleines Bächlein namens Duden fließt durch ihren Ort und versorgt sie mit den nötigen Regelialien. Es ist ein paradiesmatisches Land, in dem einem gebratene Satzteile in den Mund fliegen. Nicht einmal von der allmächtigen Interpunktion werden die Blindtexte beherrscht – ein geradezu unorthographisches Leben. Eines Tages aber beschloß eine kleine Zeile Blindtext, ihr Name war Lorem Ipsum, hinaus zu gehen in die weite Grammatik. Der große Oxmox riet ihr davon ab, da es dort wimmele von bösen Kommata, wilden Fragezeichen und hinterhältigen Semikoli, doch das Blindtextchen ließ sich nicht beirren. Es packte seine sieben Versalien, schob sich sein Initial in den Gürtel und machte sich auf den Weg. Als es die ersten Hügel des Kursivgebirges erklommen hatte, warf es einen letzten Blick zurück auf die Skyline seiner Heimatstadt Buchstabhausen, die Headline von Alphabetdorf und die Subline seiner eigenen Straße, der Zeilengasse. Wehmütig lief ihm eine rhetorische Frage über die Wange, dann setzte es seinen Weg fort. Unterwegs traf es eine Copy. Die Copy warnte das Blindtextchen, da, wo sie herkäme wäre sie ")));

	}

	public void destroy() {
		if (!store.close()) {
			System.out.println("Konnte verbindung NICHT trennen!");
		}
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rawID = request.getParameter("id");
		boolean isParsableID = rawID != null && rawID.matches("[0-9]+");

		if (isParsableID) {
			int surveyId = Integer.parseInt(request.getParameter("id"));
			Survey survey = store.getbyID(surveyId);

			if (survey != null) {
				request.setAttribute("Survey", survey);
				request.getRequestDispatcher("Survey.jsp").forward(request, response);
			} else {
				request.setAttribute("sErr", "Survey not found! try another id");
				SurveyLib(request, response);
			}

		} else if (rawID == null) {

			SurveyLib(request, response);

		} else {
			request.setAttribute("sErr", "ID is invalid");
			SurveyLib(request, response);
		}
	}

	protected void SurveyLib(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("suggestedSurveys", store.getAll(10));
		req.getRequestDispatcher("SurveyLib.jsp").forward(req, res);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO speichern
		// speichern und bedanken

		request.setAttribute("Stitle", store.getbyID(Integer.parseInt(request.getParameter("id"))).getName());
		request.getRequestDispatcher("SurveyDone.jsp").forward(request, response);
	}

}
