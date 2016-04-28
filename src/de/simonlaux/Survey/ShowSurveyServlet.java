package de.simonlaux.Survey;

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
				Arrays.asList(new SurveyQuestionString("How old are you?", "age"),
						new SurveyQuestionString("Seite2", "d"), new SurveyQuestionString("frage", "name")),
				"eine Test-Umfrage")));
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		// speichern und bedanken

		request.setAttribute("Stitle", store.getbyID(Integer.parseInt(request.getParameter("id"))).getName());
		request.getRequestDispatcher("SurveyDone.jsp").forward(request, response);
	}

}
