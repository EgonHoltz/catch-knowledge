package pt.holtz.catchknowledge.catchservice.model;

public class Answer {
	private Article article;
	private AnswerAnalytics answerAnalytics;

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public AnswerAnalytics getAnswerAnalytics() {
		return answerAnalytics;
	}
	public void setAnswerAnalytics(AnswerAnalytics answerAnalytics) {
		this.answerAnalytics = answerAnalytics;
	}
}
