package pt.holtz.catchknowledge.catchservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
	@JsonProperty("questionID")
	private String questionID;
	@JsonProperty("questionStr")
	private String questionStr;
	
	public Question(String questionID, String questionStr) {
		super();
		this.questionID = questionID;
		this.questionStr = questionStr;
	}
	public String getQuestionID() {
		return questionID;
	}
	public void setQuestionID(String questionID) {
		this.questionID = questionID;
	}
	public String getQuestionStr() {
		return questionStr;
	}
	public void setQuestionStr(String questionStr) {
		this.questionStr = questionStr;
	}
	
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", questionStr=" + questionStr + "]";
	}

	
	
}
