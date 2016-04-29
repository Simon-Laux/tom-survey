package de.simonlaux.survey;

public class SurveyQuestion {
	public static final String TYPE_STRING = "String";
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
