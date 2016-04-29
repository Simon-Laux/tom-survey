package de.simonlaux.survey;

import java.util.ArrayList;
import java.util.List;

public class InMemorySurveyStore implements SurveyStore {
	private static final InMemorySurveyStore INSTANCE = new InMemorySurveyStore();
	List<Survey> surveydata = new ArrayList<Survey>();

	public static SurveyStore getInstance() {
		return INSTANCE;
	}

	@Override
	public int add(Survey inhalt) {
		surveydata.add(inhalt);
		return (surveydata.size() - 1);

	}

	@Override
	public Survey getbyID(int id) {
		if (id <= (surveydata.size() - 1)) {
			return surveydata.get(id);
		} else {
			return null;
		}
	}

	@Override
	public List<Survey> getAll(int limit) {
		if (surveydata.size() > limit) {
			return surveydata.subList(0, limit);
		} else {
			return surveydata;
		}
	}

	@Override
	public boolean close() {
		return true;
	}
}
