package de.simonlaux.survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyTool {

	public List<SurveyQuestion> packQuestions(SurveyQuestion... list2) {
		List<SurveyQuestion> list = new ArrayList<SurveyQuestion>();
		for (int x = 0; x < list2.length; x++) {
			list.add(list2[x]);
		}
		return list;
	}
}
