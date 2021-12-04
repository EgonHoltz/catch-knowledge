package pt.holtz.catchknowledge.catchservice.model;

import java.util.List;

public class Student {
	private String inveniraStdID;
	private List<Answer> answers;
	
	public String getInveniraStdID() {
		return inveniraStdID;
	}
	public void setInveniraStdID(String inveniraStdID) {
		this.inveniraStdID = inveniraStdID;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
