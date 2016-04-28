package de.simonlaux.Survey;

public class SurveyQuestion {
	private String frage;
	private String id;
	private String typ;

	public SurveyQuestion(String text, String id, String type) {
		this.frage = text;
		this.id = id;
		this.typ = type;
	}

	public String getFrage() {
		return frage;
	}

	public String getID() {
		return id;

	}

	public String getTyp() {
		return typ;

	}

}
