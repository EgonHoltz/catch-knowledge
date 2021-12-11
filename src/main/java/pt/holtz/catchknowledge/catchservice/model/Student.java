package pt.holtz.catchknowledge.catchservice.model;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.util.CollectionUtils;

public class Student {
	private String inveniraStdID;
	private List<Article> articles;
	private List<StudentAnswer> studentAnswers;
	
	public Student(String inveniraStdID) {
		this.articles = new ArrayList<Article>();
		this.inveniraStdID = inveniraStdID;
		this.studentAnswers = new ArrayList<StudentAnswer>();
	}
	public String getInveniraStdID() {
		return inveniraStdID;
	}
	public void setInveniraStdID(String inveniraStdID) {
		this.inveniraStdID = inveniraStdID;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public List<StudentAnswer> getStudentAnswers() {
		return studentAnswers;
	}
	public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
		this.studentAnswers = studentAnswers;
	}
	public void addArticle(Article article) {
		if (CollectionUtils.isEmpty(articles)) {
			this.articles = new ArrayList<Article>();
		}
		this.articles.add(article);
		// every time that a Student add an Article, 
		// a fake analytics will be added
		ArrayList<Question> questions= article.getQuestions();
		if (!CollectionUtils.isEmpty(questions)) {
			for (Question question : questions) {
				StudentAnswer stdAnswer = new StudentAnswer(question);
				stdAnswer.setAnswer("bla bla bla bla "+(1L + (long) (Math.random() * (50L - 1L))));
				AnswerAnalytics answAnalytics = new AnswerAnalytics();
				answAnalytics.setChangedPage((1L + (long) (Math.random() * (50L - 1L))));
				answAnalytics.setDurationTime(Duration.ofMinutes((1 + (int) (Math.random() * (50 - 1)))));
				answAnalytics.setIdleTime(Duration.ofMinutes((1 + (int) (Math.random() * (50 - 1)))));
				stdAnswer.setAnswerAnalytics(answAnalytics);
				this.studentAnswers.add(stdAnswer);
			}
		}
		
	}

	
}
