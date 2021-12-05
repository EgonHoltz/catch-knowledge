package pt.holtz.catchknowledge.catchservice.model;

public class StudentAnswer {
	private Question question;
	private String answer;
	private AnswerAnalytics answerAnalytics;
	
	
	public StudentAnswer(Question question) {
		this.question = question;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public AnswerAnalytics getAnswerAnalytics() {
		return answerAnalytics;
	}
	public void setAnswerAnalytics(AnswerAnalytics answerAnalytics) {
		this.answerAnalytics = answerAnalytics;
	}
}
