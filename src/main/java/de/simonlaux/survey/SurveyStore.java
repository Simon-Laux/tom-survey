package de.simonlaux.survey;

import java.util.List;

public interface SurveyStore {

	public int add(Survey inhalt);

	public Survey getbyID(int id);

	public List<Survey> getAll(int limit);

	boolean close();

}
