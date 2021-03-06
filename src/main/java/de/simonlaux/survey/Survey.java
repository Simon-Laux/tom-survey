package de.simonlaux.survey;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	private List<SurveyQuestion> quest = new ArrayList<SurveyQuestion>();
	private String name;
	private String description;

	public Survey(String name, List<SurveyQuestion> pages, String desc) {
		this.name = name;
		this.quest = pages;
		this.description = desc;
		// TODO Auto-generated constructor stub
	}

	public SurveyQuestion getQuestion(int id) {
		return quest.get(id);
	}

	public List<SurveyQuestion> getQuestions() {
		return quest;
	}

	public int getQuestionCount() {
		return quest.size();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getShortDescription(int maxLenght) {
		if (description.length() > maxLenght) {
			return (description.substring(0, maxLenght) + "...");
		} else if (description.length() < maxLenght) {
			return description + "<br>";
		} else {
			return description;
		}
	}

}
